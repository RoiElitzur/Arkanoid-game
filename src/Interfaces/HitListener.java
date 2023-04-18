package Interfaces;
import General.Block;
import General.Ball;
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit Block type.
     * @param hitter Ball type.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
