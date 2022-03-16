package Problem2.Log;

import Problem2.Annotations.Logged;
import Problem2.Model.Calculator;
import Problem2.Utils.AnnotationChecker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
    private final static Logger logger = new Logger();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        var calculatorMethod = Calculator.class.getMethod(method.getName(), method.getParameterTypes());
        if (AnnotationChecker.isAnnotationOnClass(Calculator.class, Logged.class) || AnnotationChecker.isAnnotationOnMethod(calculatorMethod, Logged.class)) {
            createLoggerMessage(method, args);
        }
        return 10;
    }

    public void createLoggerMessage(Method method, Object[] args) throws Throwable {
        Object methodName = method.getName();
        Object object = method.getDeclaringClass().toString();
        Object objectType = method.getReturnType().toString();
        Object returnedValue = method.invoke(new Calculator(), args).toString();
        logger.info(methodName, object, objectType, args, returnedValue);
    }
}
