package com.boss.xtrain.papaer.utils;

public class SomeParamChange {
    public static Long difficultyChange(String source){
        if(source.equals("简单")){
            return Long.valueOf(123231 );
        }else if(source.equals("正常")){
            return Long.valueOf(12345);
        }else if(source.equals("复杂")){
            return  Long.valueOf(31312);
        }else {
            return null;
        }
    }
    public static Long categoryChange(String source){
        if(source.equals("java")){
            return Long.valueOf(123231);
        }else if(source.equals("python")){
            return Long.valueOf(12345);
        }else if(source.equals("linux")){
            return  Long.valueOf(31312);
        }else {
            return null;
        }
    }
}
