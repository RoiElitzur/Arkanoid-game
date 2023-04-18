package General;
import Interfaces.Sprite;
import BasicShapes.Point;
import BasicShapes.Velocity;
import BasicShapes.Line;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * This is the Ball class. It has methods that are related to the Ball object.
 */
public class Ball implements Sprite {
    private Point center;
    private int size;
    private java.awt.Color color;
    private Velocity v;
    private Point widthFrame;
    private Point heightFrame;
    private GameEnvironment gameEnvironment;
    static final int ZERO = 0;
    /**
     * This is a constructor method to initiate a Ball object.
     * @param center Point type.
     * @param r int type, represents the radius of the ball.
     * @param color Color type.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.size = r;
        this.color = color;
        this.setVelocity(ZERO, ZERO);
    }
    /**
     * This is a constructor method to initiate a Ball object.
     * @param x double type, represents the x coordinate of the ball.
     * @param y double type, represents the y coordinate of the ball.
     * @param r int type, represents the radius of the ball.
     * @param color color type, represents the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.size = r;
        this.color = color;
        this.setVelocity(ZERO, ZERO);
    }
    /**
     * This is a setter method, for setting the size of the ball's frame.
     * @param x double type.
     * @param y double type.
     */
    public void setWidthFrame(double x, double y) {
        this.widthFrame = new Point(x, y);
    }
    /**
     * This is a setter method, for setting the size of the ball's frame.
     * @param x double type.
     * @param y double type.
     */
    public void setHeightFrame(double x, double y) {
        this.heightFrame = new Point(x, y);
    }
    /**
     * This is a getter method for getting the x of the ball's center.
     * @return the x, int type.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * This is a method to set the center point of the ball.
     * @param x double type represents the x value of the point.
     * @param y double type represents the y value of the point.
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }
    /**
     * This is a getter method for getting the y of the ball's center.
     * @return the y, int type.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * This is a getter method for getting the size of the ball.
     * @return the size, int type.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * This a getter method for getting the color of the ball.
     * @return the color, Color type.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * This method draws the ball on the given DrawSurface.
     * @param surface DrawSurface type.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.size);
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.size);
    }
    /**
     * This is a setter method for setting the velocity of the ball.
     * @param v Velocity type.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }
    /**
     * This is a setter method for setting the velocity of the ball.
     * @param dx double type.
     * @param dy double type.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }
    /**
     * This is a getter method for getting the velocity of the ball.
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }
    /**
     * This is a method to set the game environment of the ball.
     * @param gameEnvironment GameEnvironment type.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * This a getter method to get the game environment of the ball.
     * @return the game environment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }
    /**
     * This method changes the velocity of the ball before the ball hits an obstacle.
     */
    public void moveOneStep() {
        Point oneStep = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(oneStep, this.getVelocity().applyToPoint(oneStep));
        CollisionInfo collisionInfo = this.getGameEnvironment().getClosestCollision(trajectory);
        if (collisionInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            Velocity v = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                    this.getVelocity());
            this.setVelocity(v);
            this.center = this.getVelocity().applyToPoint(this.center);
            Line checkLine = new Line(this.center, this.getVelocity().applyToPoint(this.center));
            CollisionInfo collisionInfoSecond = this.getGameEnvironment().getClosestCollision(checkLine);
            if (collisionInfoSecond != null) {
                v = collisionInfoSecond.collisionObject().hit(this,
                        collisionInfoSecond.collisionPoint(), this.getVelocity());
                this.setVelocity(v);
                this.center = this.getVelocity().applyToPoint(this.center);
            }
        }
    }
    /**
     * This method notify the ball that time has passed.
     */
    public void timePassed() {
        this.moveOneStep();
    }
    /**
     * This method adds tha ball to the game.
     * @param g Game type.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * This method removes tha ball from the game.
     * @param g Game type.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
  }

