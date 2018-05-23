package com.kaka.jtest.tbschedule.entities;

public class TaskModel {
  
      
    private String name;  
    private String job;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getJob() {  
        return job;  
    }  
    public void setJob(String job) {  
        this.job = job;  
    }  
    public TaskModel(String name, String job) {  
        super();  
        this.name = name;  
        this.job = job;  
    }  
    public TaskModel() {  
        super();  
    }  
      
      
} 