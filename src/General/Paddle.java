package General;
import Interfaces.Collidable;
import Interfaces.Sprite;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import BasicShapes.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private java.awt.Color color;
    private int width;
    private int speed;
    static final int LEFT_BORDER = 0;
    static final int RIGHT_BORDER = 800;
    static final int HEIGHT = 600;
    static final int PADDLE_HEIGHT = 20;
    static final int PADDLE_WIDTH = 100;
    static final double PADDLE_DIVISION = 5;
    static final double SQUARE = 2;
    static final int BORDER_THICK = 20;
    private Block paddle;
    /**
     * This a constructor method to initiate a Paddle object.
     * @param keyboard KeyboardSensor type.
     * @param speed int type.
     * @param width int type.
     */
    public Paddle(KeyboardSensor keyboard, int speed, int width) {
        this.keyboard = keyboard;
        this.speed = speed;
        this.width = width;
        Point p = new Point((RIGHT_BORDER / 2.0) - (this.width / 2.0), HEIGHT - PADDLE_HEIGHT - BORDER_THICK);
        this.paddle = new Block(p, this.width, PADDLE_HEIGHT);
        this.color = Color.YELLOW;
    }
    /**
     * This method moves the paddle to the left.
     */
    public void moveLeft() {
        if (this.getPaddleX() - BORDER_THICK == LEFT_BORDER) {
            return;
        } else if (this.getPaddleX() - this.speed - BORDER_THICK >= LEFT_BORDER) {
            Point p = new Point(this.getPaddleX() - this.speed, this.getPaddleY());
            this.paddle = new Block(p, this.width, PADDLE_HEIGHT);
        } else if (this.getPaddleX() - BORDER_THICK - this.speed != LEFT_BORDER) {
            double x = this.getPaddleX() -  this.speed - BORDER_THICK;
            Point p = new Point(this.getPaddleX() + x, this.getPaddleY());
            this.paddle = new Block(p, this.width, PADDLE_HEIGHT);
        }
    }
    /**
     * This method moves the paddle to the right.
     */
    public void moveRight() {
        if (this.getPaddleX() + this.width + BORDER_THICK == RIGHT_BORDER) {
            return;
        } else if (this.getPaddleX() + this.width + this.speed + BORDER_THICK <= RIGHT_BORDER) {
            Point p = new Point(this.getPaddleX() + this.speed, this.getPaddleY());
            this.paddle = new Block(p, this.width, PADDLE_HEIGHT);
        } else if (this.getPaddleX() + this.width + this.speed + BORDER_THICK != RIGHT_BORDER) {
            double x = this.getPaddleX() + this.width + this.speed + BORDER_THICK - RIGHT_BORDER;
            Point p = new Point(this.getPaddleX() + x, this.getPaddleY());
            this.paddle = new Block(p, this.width, PADDLE_HEIGHT);
        }
    }
    /**
     * This is a getter method to get the paddle's color.
     * @return the color of the paddle.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * This method checks if the right key or the left key had been pressed.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * This method draws the paddle on the draw surface.
     * @param d DrawSurface type.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.getColor());
        double x = this.getCollisionRectangle().getUpperLeft().getX();
        double y = this.getCollisionRectangle().getUpperLeft().getY();
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
        d.fillRectangle((int) x, (int) y, (int) width, (int) height);
        d.setColor(Color.BLACK);
        d.drawRectangle((int) x, (int) y, (int) width, (int) height);
    }
    /**
     * This is a getter method to get the collision rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }
    /**
     * This method changes the velocity of the ball according to the collision
     * point with the paddle.
     * @param collisionPoint Point type.
     * @param currentVelocity Velocity type.
     * @return the new velocity for the ball after the calculation.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double diff = PADDLE_WIDTH / PADDLE_DIVISION;
        double x1 = this.getPaddleX();
        double x2 = this.getPaddleX() + diff;
        double x3 = this.getPaddleX() + 2 * diff;
        double x4 = this.getPaddleX() + 3 * diff;
        double x5 = this.getPaddleX() + 4 * diff;
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), SQUARE) + Math.pow(currentVelocity.getDy(), SQUARE));
        if (collisionPoint.getX() >= x1 && collisionPoint.getX() < x2) {
            return Velocity.fromAngleAndSpeed(300, speed);
        } else if (collisionPoint.getX() >= x2 && collisionPoint.getX() < x3) {
            return Velocity.fromAngleAndSpeed(330, speed);
        } else if (collisionPoint.getX() >= x3 && collisionPoint.getX() < x4) {
            return new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
        } else if (collisionPoint.getX() >= x4 && collisionPoint.getX() < x5) {
            return Velocity.fromAngleAndSpeed(30, speed);
        } else {
            return Velocity.fromAngleAndSpeed(60, speed);
        }
    }
    /**
     * This method adds the paddle to the game.
     * @param g Game type.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * This is a getter method to get the x value of the paddle's upper left point.
     * @return the x value.
     */
    public double getPaddleX() {
        return this.paddle.getCollisionRectangle().getUpperLeft().getX();
    }
    /**
     * This is a getter method to get the y value of the paddle's upper left point.
     * @return the y value.
     */
    public double getPaddleY() {
        return this.paddle.getCollisionRectangle().getUpperLeft().getY();
    }

    /**
     * This is a setter method to set the paddle's color.
     * @param color Color type.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
}