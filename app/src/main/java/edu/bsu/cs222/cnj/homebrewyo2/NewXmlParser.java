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

public class NewXmlParser{

    private final String RECIPE_TAG = "recipe";

    public InputStream xmlData;
    public Document document;
    NodeList recipeNodeList;
    public NodeList recipeChildNodeList;
    Element eElement;
    String name;
    private BeerBuilder beerBuilder = new RecipeBuilder();
    private Beer currentBeer;
    public List<Beer> beerList = new ArrayList();

    public NewXmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        for(int temp = 0; temp < recipeNodeList.getLength(); temp++){
            Node currentNode = recipeNodeList.item(temp);
            beerBuilder.createBeer();
            if(isFirstNode(currentNode)){
                continue;
            }
            findCurrentName((Element) currentNode);
            findCurrentDescription((Element) currentNode);
            findCurrentBuildTime((Element) currentNode);
            findCurrentTemp((Element) currentNode);
            findCurrentStyle((Element) currentNode);
            findCurrentFermentTemp((Element) currentNode);
            findCurrentABVPercent((Element) currentNode);
            findCurrentIBUValue((Element) currentNode);
            findCurrentTargetFinalGravity((Element) currentNode);
            findCurrentTargetOriginalGravity((Element) currentNode);
            currentBeer = beerBuilder.getBeer();
            beerList.add(currentBeer);
        }
    }

    private void findCurrentName(Element currentElement) {
        beerBuilder.buildName(currentElement.getElementsByTagName("name").item(0).getTextContent());
    }
    private void findCurrentDescription(Element currentElement) {
        beerBuilder.buildDescription(currentElement.getElementsByTagName("description").item(0).getTextContent());
    }
    
    private void findCurrentBuildTime(Element currentElement){
        beerBuilder.buildTime(Integer.parseInt(currentElement.getElementsByTagName("time").item(0).getTextContent()));
    }

    private void findCurrentTemp(Element currentElement){
        beerBuilder.buildTemp(Integer.parseInt(currentElement.getElementsByTagName("temp").item(0).getTextContent()));
    }

    private void findCurrentStyle(Element currentElement){
        beerBuilder.buildStyle(currentElement.getElementsByTagName("style").item(0).getTextContent());
    }

    private void findCurrentFermentTemp(Element currentElement){
        beerBuilder.buildFermentTemp(Integer.parseInt(currentElement.getElementsByTagName("fermtemp").item(0).getTextContent()));
    }

    private void findCurrentABVPercent(Element currentElement){
        beerBuilder.buildABVPercent(Double.parseDouble(currentElement.getElementsByTagName("abvpercent").item(0).getTextContent()));
    }

    private void findCurrentIBUValue(Element currentElement){
        beerBuilder.buildIBUValue(Integer.parseInt(currentElement.getElementsByTagName("ibu").item(0).getTextContent()));
    }

    private void findCurrentTargetFinalGravity(Element currentElement){
        beerBuilder.buildTargetFinalGravity(Double.parseDouble(currentElement.getElementsByTagName("targetfg").item(0).getTextContent()));
    }

    private void findCurrentTargetOriginalGravity(Element currentElement){
        beerBuilder.buildTargetOriginalGravity(Double.parseDouble(currentElement.getElementsByTagName("targetog").item(0).getTextContent()));
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
