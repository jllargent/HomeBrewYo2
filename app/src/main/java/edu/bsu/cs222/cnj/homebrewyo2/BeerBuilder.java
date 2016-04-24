package edu.bsu.cs222.cnj.homebrewyo2;

public abstract class BeerBuilder {
    public Beer thisBeer;

    public Beer getBeer(){
        return thisBeer;
    }

    public void createBeer(){
        thisBeer = new Beer();

    }

    public abstract void buildName(String name);
    public abstract void buildDescription(String description);
    //public abstract void

/*
    public BeerBuilder(){
        thisBeer = new Beer("test");
    }*/

    public Beer returnBeer(){
        return thisBeer;
    }
}
