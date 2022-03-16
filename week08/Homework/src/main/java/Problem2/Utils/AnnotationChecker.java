package Problem2.Utils;

import java.lang.reflect.Method;

public class AnnotationChecker {
    public static boolean isAnnotationOnClass(Class className, Class annotation) {
        return className.isAnnotationPresent(annotation);
    }

    public static boolean isAnnotationOnMethod(Method method, Class annotation) {
        return method.isAnnotationPresent(annotation);
    }
}
