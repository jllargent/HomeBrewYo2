package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class NewXmlParser {

    public InputStream xmlData;
    public Document document;
    NodeList recipeNodeList;
    public NodeList recipeChildNodeList;

    public NewXmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        Element element = document.getDocumentElement();
        //recipeNodeList = element.getChildNodes();

        recipeChildNodeList = recipeNodeList.item(0).getChildNodes();/*
        //System.out.print("" + recipeNodeList.item(0).getTextContent());
        for (int i = 0; i < recipeNodeList.getLength(); i++){
            recipeChildNodeList = recipeNodeList.item(0).getChildNodes();
        }*/

    }

    private void createXMLParser()throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlData);
        document.getElementsByTagName("recipe");
        recipeNodeList = document.getElementsByTagName("recipe");
    }



}
