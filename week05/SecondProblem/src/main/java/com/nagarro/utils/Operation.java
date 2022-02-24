package com.nagarro.utils;

public class Operation{
    private String environment;
    private String description;
    public Operation(String environment,String description){
        this.environment = environment;
        this.description=description;
    }

    public String toString(){
        return "Operation:\nEnvironment: "+environment+";\nDescription: "+description+"\n\n";
    }
}
