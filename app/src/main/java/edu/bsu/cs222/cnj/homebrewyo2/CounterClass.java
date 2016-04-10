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

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cody on 3/12/2016.
 */
public class CounterClass extends CountDownTimer {
    private TextView viewTime;
    private long initialMillis;
    private ProgressDialog timerDialog;
    public CounterClass(long millisInFuture, long countDownInterval, TextView textViewTime, Context context){
        super(millisInFuture, countDownInterval);
        this.initialMillis = millisInFuture;
        viewTime = textViewTime;
        timerDialog = new ProgressDialog(context);
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
        timerDialog.setMessage("Timer's done!");
        timerDialog.setCancelable(true);
        timerDialog.show();
        showNotification();
    }

    public void showNotification() {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("HomeBrewYo")
                .setContentText("Boil's Done!")
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}