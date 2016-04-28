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

public class XmlParser {
    private final String RECIPE_TAG = "recipe";
    public InputStream xmlData;
    public Document document;
    private NodeList recipeNodeList;
    private BeerRecipe.BeerBuilder beerBuilder = new BeerRecipe.BeerBuilder();
    private BeerRecipe currentBeerRecipe;
    private Ingredient.IngredientBuilder ingredientBuilder = new Ingredient.IngredientBuilder();
    public List<BeerRecipe> beerRecipeList = new ArrayList();
    private Element currentElement;
    private Ingredient currentIngredient;
    private int i = 0;

    public XmlParser(InputStream input) throws IOException, SAXException, ParserConfigurationException {
        this.xmlData = input;
        createXMLParser();
        for(int temp = 0; temp < recipeNodeList.getLength(); temp++){
            i =0;
            Node currentNode = recipeNodeList.item(temp);
            if(isFirstNode(currentNode)){
                continue;
            }
            currentElement = (Element) currentNode;
            beerBuilder.createBeer();
            parseBeerInformation();
            parseIngredientInformation();
            currentBeerRecipe = beerBuilder.getBeer();
            beerRecipeList.add(currentBeerRecipe);
        }
    }

    private void parseIngredientInformation() {
        ingredientBuilder.createIngredient();
        ingredientBuilder.buildName(getElementStringValueByTag("yeast"));
        currentIngredient = ingredientBuilder.getIngredient();
        beerBuilder.buildYeast(currentIngredient);
        createIngredientStoreInRecipe("malt");
        createIngredientStoreInRecipe("hop");
    }

    private void parseBeerInformation() {
        parseName();
        parseDescription();
        parseTemperature();
        parseTime();
        parseStyle();
        parseFermentingTemperature();
        parseABV();
        parseIBU();
        parseGravityValues();
    }

    private void parseGravityValues() {
        beerBuilder.buildTargetOriginalGravity(getElementDoubleValueByTag("targetog"));
        beerBuilder.buildTargetFinalGravity(getElementDoubleValueByTag("targetfg"));
    }

    private void parseABV() {
        beerBuilder.buildABVPercent(getElementDoubleValueByTag("abvpercent"));
    }

    private void parseIBU(){
        beerBuilder.buildIBUValue(getElementIntValueByTag("ibu"));
    }

    private void parseStyle() {
        beerBuilder.buildStyle(getElementStringValueByTag("style"));
    }

    private void parseFermentingTemperature(){
        beerBuilder.buildFermentTemp(getElementIntValueByTag("fermtemp"));
    }

    private void parseTemperature() {
        beerBuilder.buildTime(getElementIntValueByTag("time"));
    }

    private void parseTime(){
        beerBuilder.buildTemp(getElementIntValueByTag("temp"));
    }

    private void parseName() {
        beerBuilder.buildName(getElementStringValueByTag("name"));
    }

    private void parseDescription(){
        beerBuilder.buildDescription(getElementStringValueByTag("description"));
    }

    public List<BeerRecipe> getBeerRecipeList(){
        return new ArrayList<>(beerRecipeList);
    }

    private String getElementStringValueByTag(String tag){
         return currentElement.getElementsByTagName(tag).item(i).getTextContent();
    }

    private int getElementIntValueByTag(String tag){
        return Integer.parseInt(currentElement.getElementsByTagName(tag).item(i).getTextContent());
    }

    private double getElementDoubleValueByTag(String tag){
        return Double.parseDouble(currentElement.getElementsByTagName(tag).item(i).getTextContent());
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

    private void createIngredientStoreInRecipe(String typeOfIngredient){
        i = 0;
        do{
            ingredientBuilder.createIngredient();
            ingredientBuilder.buildName(getElementStringValueByTag(typeOfIngredient + "Name"));
            ingredientBuilder.buildAmount(getElementDoubleValueByTag(typeOfIngredient + "Amount"));
            ifHopIngredient(typeOfIngredient);
            ifMaltIngredient(typeOfIngredient);
            i++;
        }while(i < currentElement.getElementsByTagName(typeOfIngredient + "Ingredient").getLength());
    }

    private void ifHopIngredient(String typeOfIngredient){
        if(typeOfIngredient.equals("hop")) {
            ingredientBuilder.buildTimeToAdd(getElementStringValueByTag(typeOfIngredient + "Time"));
            currentIngredient = ingredientBuilder.getIngredient();
            beerBuilder.addHop(currentIngredient);
        }
    }
    private void ifMaltIngredient(String typeOfIngredient){
        if(typeOfIngredient.equals("malt")){
            currentIngredient = ingredientBuilder.getIngredient();
            beerBuilder.addMalt(currentIngredient);
        }
    }
}

