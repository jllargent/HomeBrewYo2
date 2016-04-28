package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class Counter extends CountDownTimer {

    private TextView viewTime;
    private Context actContext;
    private long milliSecondsLeft;
    private Time time;

    public Counter(Time timeInfo){
        super(timeInfo.getCurrentTime(), timeInfo.getCountDownInterval());
        time = timeInfo;
        milliSecondsLeft = timeInfo.getCurrentTime();
    }

    public void setViewTime(TextView textView){
        viewTime = textView;
        textView.setText(convertToReadableTime(milliSecondsLeft));
    }

    public void setActContext(Context context){
        actContext = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        viewTime.setText(convertToReadableTime(millisUntilFinished));

        milliSecondsLeft = millisUntilFinished;
        if(convertToReadableTime(millisUntilFinished).equals(convertToReadableTime(time.getInitialTime() / 2))){
            Toast.makeText(actContext, R.string.toastAddMiddleHop, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFinish() {
        viewTime.setText(R.string.doneTimer);
        Toast.makeText(actContext, R.string.toastBeerDone, Toast.LENGTH_LONG).show();
    }

    public long getMilliSecondsLeft(){
        return milliSecondsLeft;
    }

    private String convertToReadableTime(long milliseconds){
        int seconds = (int) ((milliseconds / 1000) % 60);
        int minutes = (int) (((milliseconds / 1000) / 60));
        return String.format("%02d:%02d", minutes, seconds);
    }
}