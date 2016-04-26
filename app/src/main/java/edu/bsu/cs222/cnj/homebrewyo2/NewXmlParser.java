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
    private NodeList recipeNodeList;

    private Beer.BeerBuilder beerBuilder = new Beer.BeerBuilder();
    private Beer currentBeer;

    private Ingredient.IngredientBuilder ingredientBuilder = new Ingredient.IngredientBuilder();

    public List<Beer> beerList = new ArrayList();
    private Element currentElement;

    public NewXmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        for(int temp = 0; temp < recipeNodeList.getLength(); temp++){
            Node currentNode = recipeNodeList.item(temp);
            if(isFirstNode(currentNode)){
                continue;
            }
            currentElement = (Element) currentNode;

            beerBuilder.createBeer();
            beerBuilder.buildName(getElementStringValueByTag("name"));
            beerBuilder.buildDescription(getElementStringValueByTag("description"));
            beerBuilder.buildTime(getElementIntValueByTag("time"));
            beerBuilder.buildTemp(getElementIntValueByTag("temp"));
            beerBuilder.buildStyle(getElementStringValueByTag("style"));
            beerBuilder.buildFermentTemp(getElementIntValueByTag("fermtemp"));
            beerBuilder.buildABVPercent(getElementDoubleValueByTag("abvpercent"));
            beerBuilder.buildIBUValue(getElementIntValueByTag("ibu"));
            beerBuilder.buildTargetOriginalGravity(getElementDoubleValueByTag("targetog"));
            beerBuilder.buildTargetFinalGravity(getElementDoubleValueByTag("targetfg"));

            ingredientBuilder.createYeastIngredient();
            ingredientBuilder.buildName(getElementStringValueByTag("yeast"));
            Ingredient currentIngredient = ingredientBuilder.getIngredient();
            beerBuilder.buildYeast(currentIngredient);

            int i = 0;
            do{
                ingredientBuilder.createMaltIngredient();
                ingredientBuilder.buildName(currentElement.getElementsByTagName("maltName").item(i).getTextContent());
                currentIngredient = ingredientBuilder.getIngredient();
                beerBuilder.addMalt(currentIngredient);
                i++;
            }while(i < currentElement.getElementsByTagName("maltIngredient").getLength());







            currentBeer = beerBuilder.getBeer();
            beerList.add(currentBeer);
        }
    }

    public List<Beer> getBeerList(){
        return new ArrayList<>(beerList);
    }

    private String getElementStringValueByTag(String tag){
         return currentElement.getElementsByTagName(tag).item(0).getTextContent();
    }
    private int getElementIntValueByTag(String tag){
        return Integer.parseInt(currentElement.getElementsByTagName(tag).item(0).getTextContent());
    }
    private double getElementDoubleValueByTag(String tag){
        return Double.parseDouble(currentElement.getElementsByTagName(tag).item(0).getTextContent());
    }

    private void createXMLParser()throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(xmlData);
        document.getDocumentElement().normalize();
        recipeNodeList = document.getElementsByTagName(RECIPE_TAG);
    }

    private boolean isFirstNode(Node currentNode){
        return currentNode.getNodeType() != Node.ELEMENT_NODE;
    }


}
