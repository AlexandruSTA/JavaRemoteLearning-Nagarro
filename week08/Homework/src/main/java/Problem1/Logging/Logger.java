package Problem1.Logging;

public class Logger {
    public void log(String message) {
        System.out.println(message);
    }

    public void info(Object method, Object object, Object objectType, Object[] parameters, Object returnedValue) {
        StringBuilder parametersInfo = new StringBuilder();
        for (Object parameter : parameters) {
            parametersInfo.append(parameter).append(",");
        }
        parametersInfo.deleteCharAt(parametersInfo.length() - 1);
        System.out.println("===========LOGGER INFO===========");
        System.out.println("Method: " + method +
                "\nObject: " + object +
                "\nObject Type: " + objectType +
                "\nParameters: " + parametersInfo +
                "\nReturned Value: " + returnedValue);
        System.out.println("=================================\n");
    }
}
