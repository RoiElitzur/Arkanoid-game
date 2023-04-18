package Interfaces;
import BasicShapes.Velocity;
import General.Block;
import java.util.List;
/**
 * This is the LevelInformation Interface.
 */
public interface LevelInformation {
    /**
     * This method returns the number of balls int the game.
     * @return the number of balls, int type.
     */
    int numberOfBalls();
    /**
     * This method returns a list with the required velocity for each ball.
     * @return List type.
     */
    List<Velocity> initialBallVelocities();
    /**
     * This method returns the paddle speed.
     * @return int type.
     */
    int paddleSpeed();
    /**
     * This method returns the paddle width.
     * @return int type.
     */
    int paddleWidth();
    /**
     * This method returns the name of the current level.
     * @return String type.
     */
    String levelName();
    /**
     * This method returns a sprite with the background of the level.
     * @return Sprite type.
     */
    Sprite getBackground();
    /**
     * This method returns the Blocks that make up this level, each block contains
     * its size, color and location.
     * @return List type.
     */
    List<Block> blocks();
    /**
     * This method returns number of blocks that should be removed before the
     * level is considered to be "cleared".
     * @return int type.
     */
    int numberOfBlocksToRemove();
    /**
     * This method returns the balls Color in the level.
     * @return Color type.
     */
    java.awt.Color getBallsColor();
}
