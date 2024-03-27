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
    public Grocery getGroceryByName(String name) {
        int i = 0;
       for (Grocery grc : groceries) {

            if(grc.getName().equals(name)){
                break;

            }
            i++;

        }

       return(groceries.get(i));



    }

    public void removeGrocery(String name){

        int i = 0;
        for (Grocery grc : groceries) {

            if(grc.getName().equals(name)){
                break;

            }
            i++;

        }
        groceries.remove(i);
        return;

    }

    public ArrayList<Grocery> getGroceries() {

        return(groceries);

    }

    public void sortGroceriesByAlphabet(){
    }

    public void sortGroceriesByTime(){

    }





}
