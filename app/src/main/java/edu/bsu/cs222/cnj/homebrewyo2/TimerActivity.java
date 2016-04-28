package edu.bsu.cs222.cnj.homebrewyo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class TimerActivity extends AppCompatActivity {

    private TextView textViewTime;
    private Time time = new Time();
    private Counter decrement;
    private Button buttonStart;
    private Button buttonStop;
    private BeerRecipe currentRecipe;

    public TimerActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPageLayout();
        setUpTimerForCurrentBeer();
        setUpPage();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCurrentButtonTitle("START")) {
                    startTicking();
                } else if (isCurrentButtonTitle("RESUME")) {
                    resumeTicking();
                } else if (isCurrentButtonTitle("RESTART")) {
                    restartTimerToInitialTime();
                }
                decrement.setActContext(TimerActivity.this);
                decrement.setViewTime(textViewTime);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });
    }

    private void startTicking(){
            decrement.start();
            buttonStart.setText(R.string.restartTimer);
    }

    private void resumeTicking(){
        if(isCurrentButtonTitle("RESUME")){
            decrement = new Counter(time);
            decrement.start();
            buttonStart.setText(R.string.restartTimer);
        }
    }

    private void restartTimerToInitialTime(){
            decrement.cancel();
            time.setCurrentTime(time.getInitialTime());
            decrement = new Counter(time);
            decrement.cancel();
            buttonStart.setText(R.string.startTimer);
    }

    private void pauseTimer(){
        decrement.cancel();
        time.setCurrentTime(decrement.getMilliSecondsLeft());
        buttonStart.setText(R.string.resumeTimer);
    }

    private boolean isCurrentButtonTitle(String titleOfButton){
        return buttonStart.getText().equals(titleOfButton);
    }

    public void setUpTimerForCurrentBeer(){
        Bundle bundle = getIntent().getExtras();
        final int countDownInterval = 1000;

        currentRecipe = (BeerRecipe) bundle.getSerializable("Current Recipe");
        TextView descriptionTextView = (TextView) findViewById(R.id.beerTitle);
        assert descriptionTextView != null;
        int timerLength = currentRecipe.getTimeInMinutes() * 60;
        descriptionTextView.setText(currentRecipe.getName());

        time.setInitialTime(5 * 1000);
        time.setCountDownInterval(countDownInterval);
        time.setCurrentTime(time.getInitialTime());
        fillHopUiInfo();
        decrement = new Counter(time);
    }

    public void setUpPage(){
        buttonStart = (Button) findViewById(R.id.btnStart);
        buttonStop = (Button) findViewById(R.id.btnStop);
        textViewTime = (TextView) findViewById(R.id.timer);
        decrement.setViewTime(textViewTime);
    }

    public void fillHopUiInfo(){
        List<Ingredient> listOfHopIngredients = currentRecipe.getHops();
        ArrayList<String> detailedIngredientList = new ArrayList<>();

        for( int i =0; i < listOfHopIngredients.size(); i++){
            String s = listOfHopIngredients.get(i).getName();
            s += " | " + listOfHopIngredients.get(i).getAmount() + "g";
            s += " | " + listOfHopIngredients.get(i).getTimingToAdd();
            detailedIngredientList.add(s);
        }

        ListView listviewMalts = (ListView) findViewById(R.id.hopList);
        assert listviewMalts != null;
        listviewMalts.setClickable(true);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.checkBox, detailedIngredientList);
        listviewMalts.setAdapter(arrayAdapter);
    }

    private void createPageLayout(){
        setContentView(R.layout.activity_timer);
    }
}