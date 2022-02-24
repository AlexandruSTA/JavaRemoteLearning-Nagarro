package com.nagarro.utils;

import java.util.ArrayList;

import com.nagarro.ju.CustomException;
import com.nagarro.ju.List;

public class Operations implements List<Operation>{
    private ArrayList<Operation> operations = new ArrayList<>();

    @Override
    public void add(Operation element) throws CustomException{
        if (element == null){
            throw new CustomException("Null");
        }
        operations.add(element);
    }

    @Override
    public Operation get(int position) {
        if (position>=operations.size()){
            throw new CustomException("Index out of bounds.");
        }
        return operations.get(position);
    }

    @Override
    public boolean contains(Operation element) {
        return operations.contains(element);
    }

    @Override
    public boolean containsAll(List<Operation> foreignList) {
        for (int i=0; i<foreignList.size();i++){
            if (!operations.contains(foreignList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return operations.size();
    }

    public String toString(){
        String operationsDetails = "";
        for (Operation operation:operations) {
            operationsDetails += operation.toString();
        }
        return operationsDetails;

    }


}
