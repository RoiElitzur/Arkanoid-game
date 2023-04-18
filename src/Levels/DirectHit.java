package Levels;
import BasicShapes.Velocity;
import General.Block;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import BasicShapes.Point;
import Backgrounds.DirectHitBg;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the DirectHit class.
 */
public class DirectHit implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> ballsVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private int numberOfBlocksToRemove;
    /**
     * This is a constructor method to initiate the DirectHit object.
     */
    public DirectHit() {
        this.numberOfBalls = 1;
        this.paddleSpeed = 10;
        this.paddleWidth = 200;
        this.levelName = "Direct Hit";
        this.numberOfBlocksToRemove = 1;
        this.ballsVelocities = initialBallVelocities();
        this.background = new DirectHitBg();
    }
    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> arr = new ArrayList<Velocity>();
        Velocity v = Velocity.fromAngleAndSpeed(0, 5);
        arr.add(v);
        return arr;
    }
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }
    @Override
    public String levelName() {
        return this.levelName;
    }
    @Override
    public Sprite getBackground() {
        return this.background;
    }
    @Override
    public List<Block> blocks() {
        return genBlocksArr();
    }
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
    /**
     * This method generate the blocks array for the level.
     * @return The array, List type.
     */
    private List<Block> genBlocksArr() {
        List<Block> arr = new ArrayList<Block>();
        Block b = new Block(new Point(380, 150), 40, 40);
        b.setColor(Color.RED);
        arr.add(b);
        return arr;
    }
    /**
     * This is a getter method to get the ball's color.
     * @return the color, Color type.
     */
    public java.awt.Color getBallsColor() {
        return Color.white;
    }
}
