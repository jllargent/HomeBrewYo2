package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView textViewTime;
    private Timer timer = new Timer();

    private CounterClass decrement;

    public TimerActivity(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long countDownInterval = 1000;

        setContentView(R.layout.activity_timer);
        Bundle bundle = getIntent().getExtras();
        timer.setInitialTime(bundle.getInt("timerLength") * 1000);
        timer.setCountDownInterval(countDownInterval);
        decrement = new CounterClass(timer);
        Button buttonStart = (Button) findViewById(R.id.btnStart);
        Button buttonStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.timer1);

        assert textViewTime != null;
        textViewTime.setText("PREP");

        assert buttonStart != null;
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement.setActContext(TimerActivity.this);
                decrement.setViewTime(textViewTime);
                decrement.start();

            }
        });

        assert buttonStop != null;
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement.cancel();
            }
        });
    }

    public TextView getTimerText(){
        return textViewTime;
    }
}