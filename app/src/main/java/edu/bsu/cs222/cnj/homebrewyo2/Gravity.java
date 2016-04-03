package edu.bsu.cs222.cnj.homebrewyo2;

public class Gravity {
    private int originalGravity;
    private int finalGravity;

    public Gravity(){
    }

    public void setOriginalGravity(int gravity){
        originalGravity = gravity;
    }
    public void setFinalGravitiy( int gravity){
        finalGravity = gravity;
    }

    public int getOriginalGravity(){
        return originalGravity;
    }
    public int getFinalGravity(){
        return finalGravity;
    }
}
