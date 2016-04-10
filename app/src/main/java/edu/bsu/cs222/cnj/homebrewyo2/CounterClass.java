package edu.bsu.cs222.cnj.homebrewyo2;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.os.CountDownTimer;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cody on 3/12/2016.
 */
public class CounterClass extends CountDownTimer {
    private TextView viewTime;
    private long initialMillis;
    private ProgressDialog timerDialog;
    private Context actContext;
    public CounterClass(long millisInFuture, long countDownInterval, TextView textViewTime, Context context){
        super(millisInFuture, countDownInterval);
        this.initialMillis = millisInFuture;
        viewTime = textViewTime;
        actContext = context;
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
        Toast.makeText(actContext, "Your beer is done brewing.", Toast.LENGTH_LONG).show();
    }
}