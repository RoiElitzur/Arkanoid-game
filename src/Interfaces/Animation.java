package Interfaces;
import biuoop.DrawSurface;
/**
 * This is the Animation Interface class.
 */
public interface Animation {
    /**
     * This method draws one frame of the animation according to the game process.
     * @param d DrawSurface type.
     */
    void doOneFrame(DrawSurface d);
    /**
     * This method returns if the draw of the animation should stop.
     * It returns true if ut should stop ot false it shouldn't.
     * @return true or false.
     */
    boolean shouldStop();
}
