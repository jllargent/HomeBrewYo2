package edu.bsu.cs222.cnj.homebrewyo2;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cody on 3/12/2016.
 */
public class CounterClass extends CountDownTimer {
    TextView viewTime;
    public CounterClass(long millisInFuture, long countDownInterval, TextView textViewTime){
        super(millisInFuture, countDownInterval);
        viewTime = textViewTime;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long millis = millisUntilFinished;
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        viewTime.setText(hms);
    }

    @Override
    public void onFinish() {
        viewTime.setText("00:00:00");
    }
}
