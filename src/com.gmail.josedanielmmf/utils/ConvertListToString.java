package com.gmail.josedanielmmf.utils;

import java.util.List;

public class ConvertListToString {
    private List<String> str;

    public ConvertListToString(List<String> str){
        this.str = str;
    }

    public String getString() {
        String stringConvert = "";
        for (String s : this.str) {
            stringConvert = stringConvert.concat(s + " ");
        }
        return stringConvert.trim();
    }
}
