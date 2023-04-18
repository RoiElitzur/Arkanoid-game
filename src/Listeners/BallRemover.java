package Listeners;
import Interfaces.HitListener;
import General.GameLevel;
import General.Counter;
import General.Ball;
import General.Block;
/**
 * a BallRemover is in charge of removing balls from the game, as well as keeping count
 *  of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    static final int ONE_BALL = 1;
    /**
     * This is a constructor method to initiate the BallRemover object.
     * @param gameLevel Game type.
     * @param removedBalls Counter type.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.game = gameLevel;
        this.remainingBalls = removedBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(ONE_BALL);
    }
    /**
     * This method increases the number in the counter.
     * @param number int type.
     */
    public void increaseCounter(int number) {
        this.remainingBalls.increase(number);
    }
}
