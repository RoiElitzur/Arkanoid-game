package General;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * This is the AnimationRunner class.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    static final int FRAMES_NUMBER = 60;
    /**
     * This is a constructor method to initiate the AnimationRunner object.
     * @param gui GUI type.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = FRAMES_NUMBER;
        this.sleeper = new Sleeper();
    }
    /**
     * This method gets an Animation object and runs it.
     * @param animation Animation type.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
    /**
     * This is a getter method to get the GUI of the animation runner.
     * @return the gui.
     */
    public GUI getGui() {
        return this.gui;
    }
}