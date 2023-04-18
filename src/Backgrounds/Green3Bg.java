package Backgrounds;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * This is the Green3Bg class.
 */
public class Green3Bg implements Sprite {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    static final int BLOCKS_Y = 165;
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x0F7A04));
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(Color.BLACK);
        d.fillRectangle(50, HEIGHT - BLOCKS_Y, 100, BLOCKS_Y);
        d.setColor(new Color(0x1C0E0E));
        d.fillRectangle(85, HEIGHT - BLOCKS_Y - 50, 30, 50);
        d.fillRectangle(95, HEIGHT - BLOCKS_Y - 200, 10, 150);
        d.setColor(new Color(0xC99F05));
        d.fillCircle(100, HEIGHT - BLOCKS_Y - 215, 15);
        d.setColor(new Color(0xA10000));
        d.fillCircle(100, HEIGHT - BLOCKS_Y - 215, 10);
        d.setColor(Color.white);
        d.fillCircle(100, HEIGHT - BLOCKS_Y - 215, 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(55 + j * 10 + j * 10, HEIGHT - BLOCKS_Y + 5 + i * 35, 8, 25);
            }
        }
    }
    @Override
    public void timePassed() {
    }
}
