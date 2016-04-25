package edu.bsu.cs222.cnj.homebrewyo2;

public abstract class BeerBuilder extends Beer {
    public Beer thisBeer;

    public Beer getBeer(){
        return thisBeer;
    }

    public void createBeer(){
        thisBeer = new Beer();
    }

    public abstract void buildName(String name);
    public abstract void buildDescription(String description);
    public abstract void buildMalt(Ingredient malt);
    public abstract void buildHop(Ingredient hop);
    public abstract void buildTime(int time);
    public abstract void buildTemp(int temp);
    public abstract void buildStyle(String style);
    public abstract void buildFermentTemp(int fermentTemp);
    public abstract void buildABVPercent(double abvPercent);
    public abstract void buildIBUValue(int ibuValue);
    public abstract void buildTargetFinalGravity(int targetFinalGravity);
    public abstract void buildTargetOriginalGravity(int targetOriginalGravity);

    public Beer returnBeer(){
        return thisBeer;
    }
}
