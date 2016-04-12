package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView textViewTime = (TextView) findViewById(R.id.timer1);
    private Time time = new Time();
    Button buttonStart = (Button) findViewById(R.id.btnStart);
    Button buttonStop = (Button) findViewById(R.id.btnStop);

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

        textViewTime.setText("PREP");
        buttonStart.setText("START");

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCurrentButtonTitle("RESUME")){
                    decrement = new Counter(time);
                    buttonStart.setText("RESTART");
                }
                else if(isCurrentButtonTitle("RESTART")) {
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

    boolean isCurrentButtonTitle(String titleOfButton){
        return buttonStart.getText().equals(titleOfButton);
    }
}