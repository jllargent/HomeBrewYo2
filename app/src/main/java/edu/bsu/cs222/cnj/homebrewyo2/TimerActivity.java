package edu.bsu.cs222.cnj.homebrewyo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private Intent intent = getIntent();
    private Button buttonStart, buttonStop;
    private TextView textViewTime;
    private static int timerLength = 0;
    private CounterClass timer;

    public TimerActivity(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Bundle bundle = getIntent().getExtras();
        timerLength = bundle.getInt("timerLength") * 1000;


        buttonStart = (Button) findViewById(R.id.btnStart);
        buttonStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.timer1);

        textViewTime.setText("PREP");
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = new CounterClass(timerLength, 1000);
                timer.setActContext(TimerActivity.this);
                timer.setViewTime(textViewTime);
                timer.start();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
            }
        });
    }

    public TextView getTimerText(){
        return textViewTime;
    }
}