package edu.bsu.cs222.cnj.homebrewyo2;

import java.io.Serializable;

public class Ingredient implements Serializable {

    private String name;
    private double amount;
    private String timingToAdd;

    public static class IngredientBuilder {

        private Ingredient thisIngredient;

        public Ingredient getIngredient(){
            return thisIngredient;
        }

        public void createIngredient(){
            thisIngredient = new Ingredient();
        }

        public void buildName(String name){
            thisIngredient.name = name;
        }

        public void buildAmount(double weightInPounds){
            thisIngredient.amount = weightInPounds;
        }

        public void buildTimeToAdd(String timing){
            thisIngredient.timingToAdd = timing;
        }
    }

    public String getName(){
        return this.name;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getTimingToAdd() {
        return this.timingToAdd;
    }
}

