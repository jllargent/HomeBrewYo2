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
    private BeerBuilder builder = new RecipeBuilder();
    private Beer currentBeer;
    public List<Beer> beerList = new ArrayList();

    public NewXmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        //recipeNodeList = element.getChildNodes();
        for(int temp = 0; temp < recipeNodeList.getLength(); temp++){
            Node currentNode = recipeNodeList.item(temp);
            builder.createBeer();
            if(isFirstNode(currentNode)){
                continue;
            }

            findCurrentName((Element) currentNode);
            findCurrentDescription((Element) currentNode);
            findCurrentBuildTime((Element) currentNode);
            findCurrentTemp((Element) currentNode);
            findCurrentStyle((Element) currentNode);

            currentBeer = builder.getBeer();
            beerList.add(currentBeer);

        }/*
        recipeChildNodeList = recipeNodeList.item(0).getChildNodes();
*/
    }

    private void findCurrentName(Element currentElement) {
        builder.buildName(currentElement.getElementsByTagName("name").item(0).getTextContent());
    }
    private void findCurrentDescription(Element currentElement) {
        builder.buildDescription(currentElement.getElementsByTagName("description").item(0).getTextContent());
    }
    
    private void findCurrentBuildTime(Element currentElement){
        builder.buildTime(Integer.parseInt(currentElement.getElementsByTagName("time").item(0).getTextContent()));
    }

    private void findCurrentTemp(Element currentElement){
        builder.buildTemp(Integer.parseInt(currentElement.getElementsByTagName("temp").item(0).getTextContent()));
    }

    private void findCurrentStyle(Element currentElement){
        builder.buildStyle(currentElement.getElementsByTagName("style").item(0).getTextContent());
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

    public List<Beer> getBeerList(){
        return new ArrayList<>(beerList);
    }

}
