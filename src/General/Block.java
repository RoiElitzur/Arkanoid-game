package General;
import biuoop.DrawSurface;
import java.awt.Color;
import Interfaces.Collidable;
import Interfaces.Sprite;
import Interfaces.HitNotifier;
import BasicShapes.Rectangle;
import Interfaces.HitListener;
import BasicShapes.Point;
import BasicShapes.Velocity;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the Block class.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle collisionRectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    /**
     * This is a constructor method to initiate the Block object.
     * @param upperLeft Point type.
     * @param width double type.
     * @param height double type
     */
    public Block(Point upperLeft, double width, double height) {
        this.collisionRectangle = new Rectangle(upperLeft, width, height);
        this.color = Color.BLACK;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * This is a constructor method to initiate the Block object.
     * @param rect  Rectangle type.
     */
    public Block(Rectangle rect) {
        this.collisionRectangle = rect;
    }
    /**
     * This is method draws the block on the draw surface.
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
    @Override
    public void  timePassed() {
    }
    /**
     * This is a setter method to set the color of the block.
     * @param color color.
     */
    public void setColor(Color color) {
        this.color = color;
    }
    /**
     * This a getter method to get the color of the block.
     * @return the color of the block.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * This is a getter method to get the collision rectangle.
     * @return Rectangle type, the collision rectangle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.collisionRectangle;
    }
    /**
     * This method checks where the balls hits the rectangle and according to the checking
     * it changes the velocity of the ball.
     * @param collisionPoint Point type.
     * @param currentVelocity Velocity type.
     * @return the new velocity after the calculations.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
    double dx = currentVelocity.getDx();
    double dy = currentVelocity.getDy();
    if (collisionPoint.getX() == this.getCollisionRectangle().getUpperLeft().getX()
    || collisionPoint.getX() == (this.getCollisionRectangle().getUpperLeft().getX() + width)) {
        dx = (-1) * dx;
    }
    if (collisionPoint.getY() == this.getCollisionRectangle().getUpperLeft().getY()
    || collisionPoint.getY() == (this.getCollisionRectangle().getUpperLeft().getY() + height)) {
        dy = (-1) * dy;
    }
    this.notifyHit(hitter);
    return new Velocity(dx, dy);
    }
    /**
     * This method adds the block to the game.
     * @param g Game type.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * This method removes the block from the game.
     * @param game Game type.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
    /**
     * This method notify that a hit happened to the hit listeners.
     * @param hitter Ball type.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * This method adds the given HitListener to the hitListeners array.
     * @param hl HitListener type.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * This method removes the given HitListener from the hitListeners array.
     * @param hl HitListener.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
