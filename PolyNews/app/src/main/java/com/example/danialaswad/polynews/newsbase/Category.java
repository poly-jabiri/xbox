package com.example.danialaswad.polynews.newsbase;

/**
 * Created by danialaswad on 16/03/16.
 */
public class Category {

    public static final int POLITIC = 1, SOCIETY = 2;

    private int category = 0;

    public Category(int category){
        this.category = category;
    }
    public Category(String categ){
        if (categ.equals("POLICY")){ this.category=1;}
        else { this.category=0;}
    }
    public String toString(){
        switch (category){
            case 1: return "POLITIC";
            case 2: return "SOCIETY";
            default:return "";
        }
    }
}
