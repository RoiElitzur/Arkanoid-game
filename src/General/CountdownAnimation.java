package General;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;
/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean running;
    private boolean isFirst;
    static final int ZERO = 0;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int THICK = 20;
    /**
     * This is a constructor method to initiate the CountdownAnimation object.
     * @param numOfSeconds double type.
     * @param countFrom int type.
     * @param gameScreen SpriteCollection type.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.running = true;
        this.isFirst = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.countFrom == -1) {
            this.running = false;
        }
        d.setColor(Color.CYAN);
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.GRAY);
        if (this.countFrom != ZERO) {
            String s = String.valueOf(this.countFrom);
            d.drawText(WIDTH / 2 - THICK, HEIGHT / 2, s, 60);
        } else {
            d.drawText(WIDTH / 2 - THICK, HEIGHT / 2, "Go!",  60);
        }
        Sleeper sleeper = new Sleeper();
        if (!isFirst) {
            sleeper.sleepFor(1000);
        }
        this.countFrom -= 1;
        this.isFirst = false;
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
