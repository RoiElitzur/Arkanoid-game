package General;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * This is the PauseScreen class.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * This is a constructor method to initiate the PauseScreen object.
     * @param k KeyboardSensor type.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}
