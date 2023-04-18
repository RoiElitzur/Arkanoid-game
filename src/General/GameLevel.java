package General;
import BasicShapes.Point;
import BasicShapes.Velocity;
import Interfaces.Collidable;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Listeners.BallRemover;
import Listeners.BlockRemover;
import Listeners.ScoreTrackingListener;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.awt.Color;
import java.util.List;
/**
 * This is the GameLevel class.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Paddle paddle;
    private boolean isFirst;
    static final int ZERO = 0;
    static final int THICK = 20;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ROWS = 6;
    static final int X_TEXT = 550;
    static final int Y_TEXT = 18;
    static final int FONT = 20;
    /**
     * This is a constructor method to initiate a GameLevel object.
     * @param levelInformation LevelInformation type.
     * @param keyboardSensor KeyboardSensor type.
     * @param animationRunner AnimationRunner type.
     * @param score Counter type.
     * @param blocks Counter type.
     * @param balls Counter type.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter score, Counter blocks, Counter balls) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.blocksCounter = blocks;
        this.ballsCounter = balls;
        this.score = score;
        this.runner = animationRunner;
        this.running = true;
        this.keyboard = keyboardSensor;
        this.isFirst = true;
        this.levelInformation = levelInformation;
        this.paddle = new Paddle(this.keyboard, this.levelInformation.paddleSpeed(),
                this.levelInformation.paddleWidth());
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * This is a getter method to get the sprites SpriteCollection.
     * @return the sprites SpriteCollection.
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }
    /**
     * This is a getter method to get the environment of the game.
     * @return the environment of the game.
     */
    public GameEnvironment getGameEnvironment() {
        return this.environment;
    }
    /**
     * This method adds Collidable object to the Collidables array list
     * int the game environment.
     * @param c Collidable type.
     */
    public void addCollidable(Collidable c) {
        this.getGameEnvironment().addCollidable(c);
    }
    /**
     * This method creates the borders of the game and adds them to the game.
     * @param width int type.
     * @param height int type.
     */
    private void createWalls(int width, int height) {
        Block draw = new Block(new Point(ZERO, ZERO), width, THICK);
        Block top = new Block(new Point(ZERO, ZERO + THICK), width, THICK);
        Block bottom = new Block(new Point(ZERO, height), width, THICK);
        Block right = new Block(new Point(width - THICK, ZERO), THICK, height);
        Block left = new Block(new Point(ZERO, ZERO), THICK, height);
        draw.setColor(Color.LIGHT_GRAY);
        top.setColor(Color.GRAY);
        bottom.setColor(Color.GRAY);
        left.setColor(Color.GRAY);
        right.setColor(Color.GRAY);
        top.addToGame(this);
        bottom.addToGame(this);
        right.addToGame(this);
        left.addToGame(this);
        draw.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);
        bottom.addHitListener(ballRemover);
    }
    /**
     * This method initialize the balls.
     */
    private void createBalls() {
        List<Velocity> vArr = this.levelInformation.initialBallVelocities();
        for (Velocity v : vArr) {
            Point p = new Point(this.paddle.getPaddleX() + (this.levelInformation.paddleWidth() / 2.0),
                    this.paddle.getPaddleY() - 10);
            Ball ball = new Ball(p, 5,  this.levelInformation.getBallsColor());
            ball.setVelocity(v);
            ball.setGameEnvironment(this.getGameEnvironment());
            ball.addToGame(this);
        }
    }
    /**
     *This method adds a Sprite object to the sprites SpriteCollection.
     * @param s Sprite type.
     */
    public void addSprite(Sprite s) {
        this.getSprites().addSprite(s);
    }
    /***
     * This method initialize a new game, create the Blocks and Ball and adds them to the game.
     */
    public void initialize() {
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        addSprite(this.levelInformation.getBackground());
        this.paddle.addToGame(this);
        createBalls();
        createWalls(WIDTH, HEIGHT);
        java.awt.Color[] colorsArr = createColorArr();
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.addSprite(scoreIndicator);
        //init the blocks in the game.
        List<Block> blocksArr = this.levelInformation.blocks();
        for (Block b : blocksArr) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
        }
    }
    /**
     * This method does part of the run method. I wrote it to prevent duplicated code.
     * @param d DrawSurface type.
     */
    private void generalRun(DrawSurface d) {
        d.setColor(Color.CYAN);
        this.sprites.drawAllOn(d);
        d.drawText(X_TEXT, Y_TEXT, "Level Name : " + this.levelInformation.levelName(), FONT);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (isFirst) {
            this.runner.run(new CountdownAnimation(3, 3, this.getSprites()));
            this.isFirst = false;
        }
        d.setColor(Color.CYAN);
        this.sprites.drawAllOn(d);
        d.drawText(X_TEXT, Y_TEXT, "Level Name : " + this.levelInformation.levelName(), FONT);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space",
                    new PauseScreen(this.keyboard), this.runner.getGui()));
            this.isFirst = true;
        }
        if (this.blocksCounter.getValue() == 0 || this.ballsCounter.getValue() == 0) {
            this.running = false;
        }
    }
    /**
     * This method runs the game and starts the animation loop.
     */
    public void run() {
        this.runner.run(this);
        DrawSurface dSecond = this.runner.getGui().getDrawSurface();
        generalRun(dSecond);
        this.runner.getGui().show(dSecond);
        Sleeper sleeper = new Sleeper();
        sleeper.sleepFor(1000);
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
        arr[4] = Color.PINK;
        arr[5] = Color.GREEN;
        return arr;
    }
    /**
     * This method removes the given collidable to the collidables array in the game environment.
     * @param c Collidable type.
     */
    public void removeCollidable(Collidable c) {
        this.getGameEnvironment().removeCollidable(c);
    }

    /**
     * This method removes the given Sprite from the Sprites array.
     * @param s Sprite type.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * This method increase the score of the game.
     * @param number int type.
     */
    public void increaseScore(int number) {
        this.score.increase(number);
    }
}