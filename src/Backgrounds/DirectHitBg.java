package Backgrounds;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * This is the DirectHitBg class.
 */
public class DirectHitBg implements Sprite {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(Color.BLUE);
        d.drawCircle(400, 170, 40);
        d.drawCircle(400, 170, 80);
        d.drawCircle(400, 170, 120);
        d.drawLine(430, 170, 540, 170);
        d.drawLine(400, 200, 400, 310);
        d.drawLine(370, 170, 260, 170);
        d.drawLine(400, 140, 400, 30);
    }
    @Override
    public void timePassed() {
    }
}
