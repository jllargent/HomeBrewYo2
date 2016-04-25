package edu.bsu.cs222.cnj.homebrewyo2;

public class IngredientBuilder {

    public Ingredient thisIngredient;

    public Ingredient getIngredient(){
        return thisIngredient;
    }

    public void createMaltIngredient(){
        thisIngredient = new Ingredient(0);
    }

    public void createHopIngredient(){
        thisIngredient = new Ingredient(1);
    }

    public void createYeastIngredient() {
        thisIngredient = new Ingredient(2);
    }

    public void setAmount(double weightInPounds){
        thisIngredient.amount = weightInPounds;
    }

    public Double getAmount(){
        return thisIngredient.amount;
    }

    protected void setName(String name){
        thisIngredient.name = name;
    }

    public String getName() {
        return thisIngredient.name;
    }
}