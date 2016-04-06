package edu.bsu.cs222.cnj.homebrewyo2;

public class Gravity {
    private String originalGravity;
    private String finalGravity;

    public Gravity(){
    }

    public void setOriginalGravity(String gravity){
        originalGravity = gravity;
    }
    public void setFinalGravitiy( String gravity){
        finalGravity = gravity;
    }

    public String getOriginalGravity(){
        return originalGravity;
    }
    public String getFinalGravity(){
        return finalGravity;
    }
}
