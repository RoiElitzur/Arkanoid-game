package Listeners;
import Interfaces.HitListener;
import General.Counter;
import General.Block;
import General.Ball;
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    static final int BLOCK_SCORE = 5;
    /**
     * This is a constructor method to initiate the ScoreTrackingListener object.
     * @param scoreCounter Counter type.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(BLOCK_SCORE);
    }
}