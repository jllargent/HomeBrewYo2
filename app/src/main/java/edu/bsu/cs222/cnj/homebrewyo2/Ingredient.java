package edu.bsu.cs222.cnj.homebrewyo2;

public class Ingredient {

    private String name;
    private double amount;
    private String type;
    private String timingToAdd;

    public class IngredientBuilder {

        private Ingredient thisIngredient;

        public Ingredient getIngredient(){
            return thisIngredient;
        }

        public void createMaltIngredient(){
            thisIngredient.type = "Malt";
        }

        public void createHopIngredient(){
            thisIngredient.type = "Hop";
        }
        public void createYeastIngredient() {
            thisIngredient.type = "Yeast";
        }

        private void buildName(String name){
            thisIngredient.name = name;
        }


        private void buildAmount(double weightInPounds){
            thisIngredient.amount = weightInPounds;
        }

        private void buildTimeToAdd(String timing){
            thisIngredient.timingToAdd = timing;
        }

    }

    public String getName(){
        return this.name;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getType(){
        return this.type;
    }

    public String getTimingToAdd() {
        return this.timingToAdd;
    }
}

