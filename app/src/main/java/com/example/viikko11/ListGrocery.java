package com.example.viikko11;

import android.util.Log;

import java.util.ArrayList;

public class ListGrocery {

    private ArrayList <Grocery> groceries = new ArrayList<>();
    private static ListGrocery listGrocery = null;


    public static ListGrocery getInstance(){

        if(listGrocery == null){
            listGrocery = new ListGrocery();
        }

        return (listGrocery);

    }
    public void addGrocery(Grocery grocery){
        groceries.add(grocery);
        return;
    }
    public void getGroceryByName(String name) {

    }

    public void removeGrocery(String name){

    }

    public ArrayList<Grocery> getGroceries() {

        return(groceries);

    }

    public void sortGroceriesByAlphabet(){
    }

    public void sortGroceriesByTime(){

    }





}
