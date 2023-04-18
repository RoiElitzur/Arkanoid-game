package General;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter ballsCounter;
    private Counter score;
    /**
     * This is a constructor method to initiate the EndScreen object.
     * @param keyboard KeyboardSensor type.
     * @param ballsCounter Counter type.
     * @param score Counter type.
     */
    public EndScreen(KeyboardSensor keyboard, Counter ballsCounter, Counter score) {
        this.keyboard = keyboard;
        this.stop = false;
        this.ballsCounter = ballsCounter;
        this.score = score;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.ballsCounter.getValue() == 0) {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is : "
                    + this.score.getValue(), 32);
            d.drawText(10, d.getHeight() / 2 + 45, "-- press space to close the game.", 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is : "
                    + this.score.getValue(), 32);
            d.drawText(10, d.getHeight() / 2 + 45, "-- press space to close the game.", 32);
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}

