package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView textViewTime;
    private Time time = new Time();

    private Counter decrement;

    public TimerActivity(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long countDownInterval = 1000;

        setContentView(R.layout.activity_timer);
        Bundle bundle = getIntent().getExtras();
        time.setInitialTime(bundle.getInt("timerLength") * 1000);
        time.setCountDownInterval(countDownInterval);
        time.setCurrentTime(time.getInitialTime());
        decrement = new Counter(time);
        final Button buttonStart = (Button) findViewById(R.id.btnStart);
        Button buttonStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.timer1);

        assert textViewTime != null;
        textViewTime.setText("PREP");
        buttonStart.setText("START");

        assert buttonStart != null;
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonStart.getText().equals("RESUME")){
                    decrement = new Counter(time);
                    buttonStart.setText("RESTART");
                }
                else if(buttonStart.getText().equals("RESTART")){
                    decrement.cancel();
                    time.setCurrentTime(time.getInitialTime());
                    decrement = new Counter(time);
                }
                decrement.setActContext(TimerActivity.this);
                decrement.setViewTime(textViewTime);
                decrement.start();
                buttonStart.setText("RESTART");
            }
        });


        assert buttonStop != null;
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement.cancel();
                time.setCurrentTime(decrement.getMilliSecondsLeft());
                buttonStart.setText("RESUME");
            }
        });
    }

    public TextView getTimerText(){
        return textViewTime;
    }
}