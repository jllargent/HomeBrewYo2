package edu.bsu.cs222.cnj.homebrewyo2;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TimerTest extends TimerActivity{

    @Test
    public void TextViewGrabText_ReturnsTrue() {
        assertEquals(textViewTime.getText().toString(), "00:03:00");
    }
}
