package com.example.retrofitapp.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id")
    private int id;

    @SerializedName("employee_name")
    private String employee_name;


    public String getEmployee_name() {
        return employee_name;
    }
}
