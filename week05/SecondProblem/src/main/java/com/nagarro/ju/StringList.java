package com.nagarro.ju;

import com.nagarro.utils.Operation;
import com.nagarro.utils.Operations;

public class StringList implements List<String> {
    //private final ArrayList<String> numbers = new ArrayList<>();
    private Integer[] numbers;
    private final Operations operations;

    public StringList() {
        this.numbers = new Integer[1];
        this.operations = new Operations();
    }

    @Override
    public void add(String element) throws CustomException {
        if (element == null || element.equals("")) {
            throw new CustomException("Null");
        }
        if (!isANumber(element)) {
            throw new CustomException("Invalid number.");
        }
        numbers[numbers.length-1] = Integer.parseInt(element);
        updateNumbersLength();
        operations.add(createOperation("Add method", "Adding element " + element + "."));
    }

    @Override
    public String get(int position) throws CustomException {
        if (position >= numbers.length-1) {
            throw new CustomException("Index out of bounds.");
        }
        operations.add(createOperation("Get method", "Getting the element at position " + position + "."));
        return Integer.toString(numbers[position]);
    }

    @Override
    public boolean contains(String element) {
        operations.add(createOperation("Contains method", "Verifying if element " + element + " exists."));
        if (element == null || element.equals("")) {
            throw new CustomException("Null");
        }
        if (!isANumber(element)) {
            throw new CustomException("Invalid number.");
        }
        int convertedNumber = Integer.parseInt(element);
        for (int number : numbers) {
            if (number == convertedNumber) {
                return true;
            }
        }
        return false;


    }

    @Override
    public boolean containsAll(List<String> foreignList) {
        operations.add(createOperation("ContainsAll method", "Verifying foreignList is contained within the numbers list."));
        for (int i = 0; i < foreignList.size(); i++) {
            if (!contains(foreignList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        operations.add(createOperation("Size method", "Retrieving the size of the list."));
        return numbers.length-1;
    }

    public boolean isANumber(String number) {
        operations.add(createOperation("VerifyStringRepresentationOfNumber method", "Verifying if " + number + " is a number."));
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private void updateNumbersLength() {
        Integer[] clone = cloneNumbers(numbers);
        numbers = new Integer[numbers.length+1];
        numbers[numbers.length-1] = null;
        copyNumbers(clone);
    }

    private Integer[] cloneNumbers(Integer[] numbers) {
        Integer[] clone = new Integer[numbers.length];
        for (Integer i = 0; i < numbers.length; i++) {
            clone[i] = numbers[i];
        }
        return clone;
    }

    private void copyNumbers(Integer[] numbers){
        for (Integer i=0;i<numbers.length;i++){
            this.numbers[i]=numbers[i];
        }
    }



    public Operation createOperation(String environment, String description) {
        return new Operation(environment, description);
    }

    public String displayOperations() {
        return operations.toString();
    }
}
