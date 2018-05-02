package cn.lvhaosir.aop;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by lvhaosir on 2018/5/2.
 */
@Aspect
@Component
public class SystemLogAspect {

    private Logger log = LoggerFactory.getLogger(SystemLogAspect.class);


    @Pointcut("@annotation(cn.exrick.manager.annotation.SystemControllerLog)")
    public void controllerAspect {
        log.info("==============controllerAspect=============");
    }

}
