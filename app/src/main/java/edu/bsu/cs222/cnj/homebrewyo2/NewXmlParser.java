package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Document;

import java.io.InputStream;

public class NewXmlParser {

    public InputStream xmlData;
    public Document document;

    public NewXmlParser(InputStream input){
        this.xmlData = input;

    }

}
