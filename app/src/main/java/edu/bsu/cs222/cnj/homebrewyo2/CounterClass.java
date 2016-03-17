package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cody on 3/12/2016.
 */
public class CounterClass extends CountDownTimer {
    TextView viewTime;
    long initialMillis;
    public CounterClass(long millisInFuture, long countDownInterval, TextView textViewTime){
        super(millisInFuture, countDownInterval);
        this.initialMillis = millisInFuture;
        viewTime = textViewTime;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        int seconds = (int) (millisUntilFinished / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        String ms = String.format("%02d:%02d", minutes, seconds);
        viewTime.setText(ms);
    }

    @Override
    public void onFinish() {
        viewTime.setText("DONE");
    }
}