package cn.lvhaosir.annotation;

import java.lang.annotation.*;

/**
 * Created by lvhaosir on 2018/5/2.
 */
// 作用于参数或者方法上
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String description() default "";
}
