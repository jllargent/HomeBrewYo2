package edu.bsu.cs222.cnj.homebrewyo2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class BeerListTransporter implements Serializable {
    List<Beer> recipeList;

    public BeerListTransporter(ArrayList<Beer> beerList){
        this.recipeList = beerList;
    }

    public List<Beer> getBeerList(){
        return new ArrayList<>(this.recipeList);
    }
}
