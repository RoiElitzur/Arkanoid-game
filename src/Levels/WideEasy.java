package Levels;
import Backgrounds.WideEasyBg;
import BasicShapes.Velocity;
import General.Block;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import BasicShapes.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the WideEasy object.
 */
public class WideEasy implements LevelInformation {
    static final int THICK = 20;
    static final int NUMBER_OF_BALLS = 10;
    static final int VEL_MULTIPLY = 15;
    static final int BALLS_SPEED = 5;
    static final int PADDLE_SPEED = 10;
    static final int PADDLE_WIDTH = 550;
    static final int NUMBER_OF_BLOCKS = 15;
    static final double BLOCK_WIDTH = 50;
    static final double BLOCK_HEIGHT = 20;
    static final int BLOCKS_Y = 280;
    static final int DIFF = 78;
    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> arr = new ArrayList<Velocity>();
        for (int i = 1; i <= NUMBER_OF_BALLS; i++) {
            Velocity v = Velocity.fromAngleAndSpeed((i * VEL_MULTIPLY) - DIFF, BALLS_SPEED);
            arr.add(v);
        }
        return arr;
    }
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }
    @Override
    public String levelName() {
        return "Wide Easy";
    }
    @Override
    public Sprite getBackground() {
        return new WideEasyBg();
    }
    @Override
    public List<Block> blocks() {
        List<Block> blocksArr = new ArrayList<Block>();
        java.awt.Color[] colorsArr = createColorArr();
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            Point p = new Point(THICK + i * BLOCK_WIDTH, BLOCKS_Y);
            Block b = new Block(p, BLOCK_WIDTH, BLOCK_HEIGHT);
            b.setColor(colorsArr[i]);
            blocksArr.add(b);
        }
        return blocksArr;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS;
    }
    @Override
    public java.awt.Color getBallsColor() {
        return Color.white;
    }
    /**
     * This method creates a colors array list.
     * @return The colors array list.
     */
    public java.awt.Color[] createColorArr() {
        java.awt.Color[] arr = new java.awt.Color[NUMBER_OF_BLOCKS];
        arr[0] = Color.RED;
        arr[1] = Color.RED;
        arr[2] = Color.ORANGE;
        arr[3] = Color.ORANGE;
        arr[4] = Color.YELLOW;
        arr[5] = Color.YELLOW;
        arr[6] = Color.GREEN;
        arr[7] = Color.GREEN;
        arr[8] = Color.GREEN;
        arr[9] = Color.BLUE;
        arr[10] = Color.BLUE;
        arr[11] = Color.PINK;
        arr[12] = Color.PINK;
        arr[13] = Color.CYAN;
        arr[14] = Color.CYAN;
        return arr;
    }
}
