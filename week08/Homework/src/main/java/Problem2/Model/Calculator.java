package Problem2.Model;

import Problem2.Annotations.Logged;
import Problem2.Service.Operations;

@Logged
public class Calculator implements Operations {
    @Override
    public int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    @Override
    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    @Override
    public int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    @Override
    public int divide(int firstOperand, int secondOperand) {
        return (firstOperand / secondOperand);
    }
}
