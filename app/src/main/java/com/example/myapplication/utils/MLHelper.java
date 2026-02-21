package com.example.myapplication.utils;



public class MLHelper {

    public static String predict(double avgReaction){
        if(avgReaction > 500)
            return "High Risk";
        else
            return "Low Risk";
    }
}