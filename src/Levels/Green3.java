package Levels;
import Backgrounds.Green3Bg;
import BasicShapes.Velocity;
import General.Block;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import BasicShapes.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the Green3 object.
 */
public class Green3 implements LevelInformation {
    static final int THICK = 20;
    static final int WIDTH = 800;
    static final int NUMBER_OF_BALLS = 2;
    static final int VEL_MULTIPLY = 45;
    static final int BALLS_SPEED = 5;
    static final int PADDLE_SPEED = 10;
    static final int PADDLE_WIDTH = 120;
    static final int NUMBER_OF_BLOCKS = 40;
    static final double BLOCK_WIDTH = 50;
    static final double BLOCK_HEIGHT = 20;
    static final int BLOCKS_Y = 150;
    static final int DIFF = 66;
    static final int ROWS = 5;
    static final int MAX_BLOCKS = 10;
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
        return "Green 3";
    }
    @Override
    public Sprite getBackground() {
        return new Green3Bg();
    }
    @Override
    public List<Block> blocks() {
        List<Block> blocksArr = new ArrayList<Block>();
        java.awt.Color[] colorsArr = createColorArr();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < MAX_BLOCKS - i; j++) {
                Point p = new Point(WIDTH - THICK - BLOCK_WIDTH - (j * BLOCK_WIDTH),
                        BLOCKS_Y + (i * BLOCK_HEIGHT));
                Block b = new Block(p, BLOCK_WIDTH, BLOCK_HEIGHT);
                b.setColor(colorsArr[i]);
                blocksArr.add(b);
            }
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
        java.awt.Color[] arr = new java.awt.Color[ROWS];
        arr[0] = Color.GRAY;
        arr[1] = Color.RED;
        arr[2] = Color.YELLOW;
        arr[3] = Color.BLUE;
        arr[4] = Color.WHITE;
        return arr;
    }
}
