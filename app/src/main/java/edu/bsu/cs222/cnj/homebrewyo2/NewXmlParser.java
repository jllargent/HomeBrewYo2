package edu.bsu.cs222.cnj.homebrewyo2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

    private final String RECIPE_TAG = "recipe";

    public InputStream xmlData;
    public Document document;
    NodeList recipeNodeList;
    public NodeList recipeChildNodeList;
    Element eElement;
    String name;

    public NewXmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        //recipeNodeList = element.getChildNodes();
        for(int temp = 0; temp < recipeNodeList.getLength(); temp++){
            Node currentNode = recipeNodeList.item(0);

            if(isFirstNode(currentNode)){
                continue;
            }

            findCurrentName((Element) currentNode);


        }/*
        recipeChildNodeList = recipeNodeList.item(0).getChildNodes();
*/
    }

    private void findCurrentName(Element currentElement) {
        name = currentElement.getElementsByTagName("name").item(0).getTextContent();
    }

    private void createXMLParser()throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlData);
        //document.getElementsByTagName(RECIPE_TAG);
        document.getDocumentElement().normalize();
        recipeNodeList = document.getElementsByTagName(RECIPE_TAG);
    }

    private boolean isFirstNode(Node currentNode){
        return currentNode.getNodeType() != Node.ELEMENT_NODE;
    }


}
