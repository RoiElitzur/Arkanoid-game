package General;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;
    static final int X_TEXT = 375;
    static final int Y_TEXT = 18;
    static final int FONT = 20;
    /**
     * This is a constructor method to initiate the ScoreIndicator object.
     * @param c Counter type.
     */
    public ScoreIndicator(Counter c) {
        this.scoreCounter = c;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(X_TEXT, Y_TEXT, "Score :" + this.scoreCounter.getValue(), FONT);
    }
    @Override
    public void timePassed() {
    }

}
