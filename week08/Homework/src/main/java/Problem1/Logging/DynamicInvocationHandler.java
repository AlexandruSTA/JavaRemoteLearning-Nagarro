package Problem1.Logging;

import Problem1.Model.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
    private final static Logger logger = new Logger();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object methodName = method.getName();
        Object object = method.getDeclaringClass().toString();
        Object objectType = method.getReturnType().toString();
        Object returnedValue = method.invoke(new Calculator(), args).toString();

        logger.info(methodName, object, objectType, args, returnedValue);
        return 10;
    }
}
