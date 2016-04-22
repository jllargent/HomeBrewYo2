package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Node;

/**
 * Created by Nathan on 4/21/2016.
 */
public class Beer {
    private String name;


    public Beer(String nameFromFile){
        this.name = nameFromFile;
    }

    public String returnName(){
        return name;
    }
}
