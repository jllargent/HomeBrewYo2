package edu.bsu.cs222.cnj.homebrewyo2;

public class Time {
    private long initialTime = 0;
    private long currentTime;
    private long countDownInterval;

    public Time(){
    }

    public void setInitialTime(long millis){
        initialTime = millis;
    }

    public void setCountDownInterval(long increment){
        countDownInterval = increment;
    }

    public void setCurrentTime(long time){
        currentTime = time;
    }

    public long getInitialTime(){
        return initialTime;
    }

    public long getCountDownInterval(){
        return countDownInterval;
    }

    public long getCurrentTime(){
        return currentTime;
    }
}
