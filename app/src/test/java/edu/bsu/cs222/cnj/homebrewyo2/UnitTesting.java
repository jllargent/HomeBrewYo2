package edu.bsu.cs222.cnj.homebrewyo2;

import android.media.Image;
import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.Button;
import android.widget.ImageView;

public class UnitTesting extends ActivityInstrumentationTestCase2<MainActivity>{
    private Solo solo;

    public UnitTesting(){
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void test_Preconditions() {
        assertNotNull(solo);
    }

    public void test_MainChangeActivityToTimerOnButtonPress() throws Exception{
        ImageView btn_timer = (ImageView) solo.getView(R.id.timerButton);
        solo.clickOnView(btn_timer);
        solo.assertCurrentActivity("check for activity", TimerActivity.class);
    }
}
