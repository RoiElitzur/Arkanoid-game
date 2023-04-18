package Listeners;
import Interfaces.HitListener;
import General.GameLevel;
import General.Counter;
import General.Block;
import General.Ball;
/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 *  of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    static final int ONE_BLOCK = 1;
    static final int HUNDRED_POINTS = 100;
    /**
     * This is a constructor method to initiate a block remover object.
     * @param game Game type.
     * @param removedBlocks Counter type.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(ONE_BLOCK);
        if (this.remainingBlocks.getValue() == 0) {
            this.game.increaseScore(HUNDRED_POINTS);
        }
    }
    /**
     * This method increases the counter.
     * @param number int type.
     */
    public void increaseCounter(int number) {
        this.remainingBlocks.increase(number);
    }
}