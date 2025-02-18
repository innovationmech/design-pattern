package template.annotated;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 注解在运行时保留
@Target(ElementType.METHOD)        // 注解可以用于方法
public @interface Hook {
    String description() default ""; // 可以添加一个描述信息，可选
}
