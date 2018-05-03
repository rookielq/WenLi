package cn.lvhaosir.aop;


import cn.lvhaosir.annotation.SystemControllerLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by lvhaosir on 2018/5/2.
 */
@Aspect
@Component
public class SystemLogAspect {

    private Logger log = LoggerFactory.getLogger(SystemLogAspect.class);

    private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");

    @Pointcut("@annotation(cn.lvhaosir.annotation.SystemControllerLog)")
    public void controllerAspect() {
        log.info("==============controllerAspect=============");
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==============进入了Controller切面,日志系统==============");
        // 线程绑定变量
        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);
    }

    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) throws Exception {


        // 请求开始时间
        Date logStartTime = beginTimeThreadLocal.get();
        String name = getControllerMethodDescription(joinPoint);
        System.out.println(name);
        long beginTime = beginTimeThreadLocal.get().getTime();
        long endTime = System.currentTimeMillis();

        System.out.println("开始时间:"+logStartTime);
        System.out.println("结束时间:"+endTime);
        System.out.println("==============结束了Controller切面,日志系统==============");
    }


    /**
     *  获取注解中对方法的描述信息，用于Controller层注解
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {

        // 获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取相关参数
        Object[] arguments = joinPoint.getArgs();
        // 生成类对象
        Class targetClass = Class.forName(targetName);
        // 获取该类中的方法
        Method[] methods = targetClass.getMethods();

        String description = "";

        for (Method method : methods ) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class[] clazzs = method.getParameterTypes();
            // 比较方法中参数个数与从切面中获取的参数个数是否相同。
            // 原因是方法可以重载
            if (clazzs.length != arguments.length) {
                continue;
            }
            description = method.getAnnotation(SystemControllerLog.class).description();
        }
        return description;

    }

}
