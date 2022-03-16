package Problem1;

import Problem1.Logging.DynamicInvocationHandler;
import Problem1.Service.Operations;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        Operations calculatorProxyInstance = (Operations) Proxy.newProxyInstance(
                Operations.class.getClassLoader(),
                new Class[]{Operations.class},
                new DynamicInvocationHandler());
        calculatorProxyInstance.add(10, 12);
        calculatorProxyInstance.subtract(10, 12);
        calculatorProxyInstance.multiply(10, 12);
        calculatorProxyInstance.divide(10, 12);
    }
}
