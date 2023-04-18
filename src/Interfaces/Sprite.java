package Interfaces;
import biuoop.DrawSurface;
/**
 * This is the Sprite interface.
 */
public interface Sprite {
    /**
     * This nethod draws the sprite to the screen.
     * @param d DrawSurface type.
     */
    void drawOn(DrawSurface d);
    /**
     * This method notify the sprite that time has passed.
     */
    void timePassed();
}