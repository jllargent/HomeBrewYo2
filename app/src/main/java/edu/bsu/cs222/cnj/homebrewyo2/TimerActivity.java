package edu.bsu.cs222.cnj.homebrewyo2;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private Intent intent = getIntent();
    private Button btnStart, btnStop;
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


        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.timer1);

        textViewTime.setText("PREP");
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = new CounterClass(timerLength, 1000, textViewTime, TimerActivity.this);
                timer.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
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