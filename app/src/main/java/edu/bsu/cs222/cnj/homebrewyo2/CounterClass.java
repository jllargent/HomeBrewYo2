package edu.bsu.cs222.cnj.homebrewyo2;


import android.app.ProgressDialog;
import android.content.Context;

import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;


public class CounterClass extends CountDownTimer {
    private TextView viewTime;
    private long initialMillis;
    private ProgressDialog timerDialog;
    private Context actContext;

    TextView textViewTime;
    Context context;

    public CounterClass(long totalMillis, long countDownInterval){
        super(totalMillis, countDownInterval);
        setInitialMillis(totalMillis);
    }
    public void setViewTime( TextView textView){
        viewTime = textView;
    }
    public void setActContext(Context context){
        actContext = context;
    }
    public void setInitialMillis(long milliseconds){
        initialMillis = milliseconds;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        viewTime.setText(convertToReadableTime(millisUntilFinished));
    }

    @Override
    public void onFinish() {
        viewTime.setText("DONE");
        Toast.makeText(actContext, "Your beer is done brewing.", Toast.LENGTH_LONG).show();
    }

    private String convertToReadableTime(long milliseconds){
        int seconds = (int) ((milliseconds / 1000) % 60);
        int minutes = (int) (((milliseconds / 1000) / 60));
        return String.format("%02d:%02d", minutes, seconds);
    }

    public long getInitialMillis() {
        return initialMillis;
    }
}