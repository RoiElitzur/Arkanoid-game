package Backgrounds;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 *This is the WideEasyBg class.
 */
public class WideEasyBg implements Sprite {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    static final int BLOCKS_Y = 280;
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(Color.ORANGE);
        for (int i = 0; i < 160; i++) {
            d.drawLine(110, 100, 5 * i, BLOCKS_Y);
        }
        d.setColor(new Color(0xFCEDAB));
        d.fillCircle(110, 110, 90);
        d.setColor(new Color(0xFFF566));
        d.fillCircle(110, 110, 70);
        d.setColor(new Color(0xFFF978));
        d.fillCircle(110, 110, 60);
    }
    @Override
    public void timePassed() {
    }
}
