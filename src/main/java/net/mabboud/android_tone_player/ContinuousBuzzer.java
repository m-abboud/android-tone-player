package net.mabboud.android_tone_player;

/**
 * A buzzer that will continue playing until stop() is called.
 */
public class ContinuousBuzzer extends TonePlayer{
    protected double pausePeriodSeconds = 5;
    protected int pauseTimeInMs = 1;

    public int getPauseTimeInMs() {
        return pauseTimeInMs;
    }

    public void setPauseTimeInMs(int pauseTimeInMs) {
        this.pauseTimeInMs = pauseTimeInMs;
    }

    public double getPausePeriodSeconds() {
        return pausePeriodSeconds;
    }

    public void setPausePeriodSeconds(double pausePeriodSeconds) {
        this.pausePeriodSeconds = pausePeriodSeconds;
    }

    protected void asyncPlayTrack(final double toneFreqInHz) {
        playerWorker = new Thread(new Runnable() {
            public void run() {
                while (isPlaying) {
                    // will pause every x seconds useful for determining when a certain amount
                    // of time has passed while whatever the buzzer is signaling is active
                    playTone(toneFreqInHz, pausePeriodSeconds);
                    try {
                        Thread.sleep(pauseTimeInMs);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        });

        playerWorker.start();
    }
}
