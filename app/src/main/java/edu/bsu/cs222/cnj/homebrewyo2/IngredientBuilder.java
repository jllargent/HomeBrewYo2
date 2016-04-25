package edu.bsu.cs222.cnj.homebrewyo2;

public class IngredientBuilder extends Ingredient {

    public Ingredient thisIngredient;

    public Ingredient getIngredient(){
        return thisIngredient;
    }

    public void createMaltIngredient(){
        thisIngredient = new NewMalt();
    }

    public void createHopIngredient(){
        thisIngredient = new NewHop();
    }

    public void createYeastIngredient() {
        thisIngredient = new Ingredient();
    }
}