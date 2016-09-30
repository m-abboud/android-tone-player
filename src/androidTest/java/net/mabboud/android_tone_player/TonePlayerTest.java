package net.mabboud.android_tone_player;

import android.app.Activity;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(AndroidJUnit4.class)
public class TonePlayerTest extends ActivityUnitTestCase<Activity> {
    public TonePlayerTest() {
        super(Activity.class);
    }

    @Test
    // Annoying android studio isn't picking up the tests unless the method names start with the
    // oh so redundant 'test' word. Maybe I'll figure out a fix and write a blog post about it...
    public void testGivenOneTimePlayer_Playing_whenStoppedWhileStillBuzzing_thenNoError() {
        // bit of a smoke test to make sure nothing goes terribly wrong
        OneTimeBuzzer buzzer = new OneTimeBuzzer(3);
        buzzer.play();
        buzzer.stop();
    }

    @Test
    public void testGivenOneTimePlayer_whenPlayed_thenIsStoppedAfterWaiting() throws InterruptedException {
        OneTimeBuzzer buzzer = new OneTimeBuzzer(.2);

        buzzer.play();
        Thread.sleep(1000);

        Assert.assertFalse(buzzer.isPlaying);
    }

    @Test
    public void testGivenContinuousBuzzer_whenPlayed_thenStillPlayingAfterWaiting() throws InterruptedException {
        ContinuousBuzzer buzzer = new ContinuousBuzzer();

        buzzer.play();
        Thread.sleep(1500);

        Assert.assertTrue(buzzer.isPlaying);
        buzzer.stop();
    }

    @Test
    public void testGivenContinuousBuzzerPlaying_whenStopped_thenBuzzerDoesStop() throws InterruptedException {
        ContinuousBuzzer buzzer = new ContinuousBuzzer();
        buzzer.play();

        Thread.sleep(500);
        buzzer.stop();

        Assert.assertFalse(buzzer.isPlaying);
    }
}