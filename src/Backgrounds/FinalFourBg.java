package Backgrounds;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * This is the FinalFourBg class.
 */
public class FinalFourBg implements Sprite {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(0x1D3D8C));
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(new Color(0xB2B2B6));
        //Draws the lines
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 12; k++) {
                d.drawLine(110 + 10 * k + j * 490, 400 + j * 100, 120 + 12 * k + j * 490, 600);
            }
        }
        //Draws the clouds
        for (int i = 0; i < 2; i++) {
            d.setColor(new Color(0xB2B2B6));
            d.fillCircle(115 + i * 490, 400 + i * 100, 30);
            d.fillCircle(130 + i * 490, 420 + i * 100, 30);
            d.setColor(new Color(0x909096));
            d.fillCircle(145 + i * 490, 385 + i * 100, 35);
            d.setColor(Color.GRAY);
            d.fillCircle(200 + i * 490, 400 + i * 100, 35);
            d.fillCircle(170 + i * 490, 425 + i * 100, 25);
        }
    }
    @Override
    public void timePassed() {
    }
}
