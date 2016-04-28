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
    private final String NAME_TAG = "name";
    private final String STYLE_TAG = "style";
    private final String DESCRIPTION_TAG = "description";
    private final String TIME_TAG = "time";
    private final String TEMPERATURE_TAG = "temp";
    private final String FERMENT_TAG = "fermtemp";
    private final String IBU_TAG = "ibu";
    private final String ABV_TAG = "abvpercent";
    private final String ORGINAL_GRAVITY_TAG = "targetog";
    private final String FINAL_GRAVITY_TAG = "targetfg";
    private final String MALT_TAG = "malt";
    private final String HOP_TAG = "hop";
    private final String YEAST_TAG = "yeast";

    public InputStream xmlData;
    public List<BeerRecipe> beerRecipeList = new ArrayList<>();
    private NodeList recipeNodeList;
    private BeerRecipe.BeerBuilder beerBuilder = new BeerRecipe.BeerBuilder();
    private Ingredient.IngredientBuilder ingredientBuilder = new Ingredient.IngredientBuilder();
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
            BeerRecipe currentBeerRecipe = beerBuilder.getBeer();
            beerRecipeList.add(currentBeerRecipe);
        }
    }

    private void parseIngredientInformation() {
        parseYeastIngredient();
        createIngredientStoreInRecipe(MALT_TAG);
        createIngredientStoreInRecipe(HOP_TAG);
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
        beerBuilder.buildTargetOriginalGravity(getElementDoubleValueByTag(ORGINAL_GRAVITY_TAG));
        beerBuilder.buildTargetFinalGravity(getElementDoubleValueByTag(FINAL_GRAVITY_TAG));
    }

    private void parseABV() {
        beerBuilder.buildABVPercent(getElementDoubleValueByTag(ABV_TAG));
    }

    private void parseIBU(){
        beerBuilder.buildIBUValue(getElementIntValueByTag(IBU_TAG));
    }

    private void parseStyle() {
        beerBuilder.buildStyle(getElementStringValueByTag(STYLE_TAG));
    }

    private void parseFermentingTemperature(){
        beerBuilder.buildFermentTemp(getElementIntValueByTag(FERMENT_TAG));
    }

    private void parseTemperature() {
        beerBuilder.buildTime(getElementIntValueByTag(TIME_TAG));
    }

    private void parseTime(){
        beerBuilder.buildTemp(getElementIntValueByTag(TEMPERATURE_TAG));
    }

    private void parseName() {
        beerBuilder.buildName(getElementStringValueByTag(NAME_TAG));
    }

    private void parseDescription(){
        beerBuilder.buildDescription(getElementStringValueByTag(DESCRIPTION_TAG));
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
        Document document = builder.parse(xmlData);
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
        if(typeOfIngredient.equals(HOP_TAG)) {
            ingredientBuilder.buildTimeToAdd(getElementStringValueByTag(typeOfIngredient + "Time"));
            currentIngredient = ingredientBuilder.getIngredient();
            beerBuilder.addHop(currentIngredient);
        }
    }
    private void ifMaltIngredient(String typeOfIngredient){
        if(typeOfIngredient.equals(MALT_TAG)){
            currentIngredient = ingredientBuilder.getIngredient();
            beerBuilder.addMalt(currentIngredient);
        }
    }

    private void parseYeastIngredient(){
        ingredientBuilder.createIngredient();
        ingredientBuilder.buildName(getElementStringValueByTag(YEAST_TAG));
        currentIngredient = ingredientBuilder.getIngredient();
        beerBuilder.buildYeast(currentIngredient);
    }
}

