package net.mabboud.android_tone_player;

import android.app.Application;
import android.test.ApplicationTestCase;
import org.testng.annotations.Test;

public class TonePlayerTest extends ApplicationTestCase<Application> {
    public TonePlayerTest() {
        super(Application.class);
    }

    @Test
    public void givenOneTimePlayer_Playing_whenStoppedWhileStillBuzzing_thenNoError() {
        // bit of a smoke test to make sure nothing goes terribly wrong
        OneTimeBuzzer buzzer = new OneTimeBuzzer(3);
        buzzer.play();
        buzzer.stop();
    }
}