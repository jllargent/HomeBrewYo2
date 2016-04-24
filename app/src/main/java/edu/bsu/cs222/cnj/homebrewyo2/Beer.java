package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Node;

import java.util.List;

public class Beer {
    private String name;
    private String description;
    private List<Malt> malts;
    private List<Hop> hops;

/*
    public Beer(String nameFromFile){
        this.name = nameFromFile;
    }*/

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String returnName(){
        return name;
    }

    public String returnDescription(){
        return description;
    }

    public void addMalt(Malt malt){
        this.malts.add(malt);
    }

    public List<Malt> getMalts(){
        return this.malts;
    }
}
