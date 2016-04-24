package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    private String name;
    private String description;
    private List<Malt> malts = new ArrayList<>();
    private List<Hop> hops = new ArrayList<>();

/*
    public Beer(String nameFromFile){
        this.name = nameFromFile;
    }*/

    protected void setName(String name){
        this.name = name;
    }

    protected void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void addMalt(Malt malt){
        this.malts.add(malt);
    }

    public List<Malt> getMalts(){
        return new ArrayList<>(this.malts);
    }
}
