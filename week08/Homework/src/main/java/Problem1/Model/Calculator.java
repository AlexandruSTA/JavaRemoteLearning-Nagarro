package Problem1.Model;

import Problem1.Service.Operations;

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
