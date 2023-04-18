package Interfaces;
import BasicShapes.Rectangle;
import BasicShapes.Velocity;
import BasicShapes.Point;
import General.Ball;
/**
 * This is the Collidable interface.
 */
public interface Collidable {
    /**
     * This is a getter method to get the collision rectangle.
     * @return Rectangle type, the collision rectangle.
     */
    Rectangle getCollisionRectangle();
    /**
     * This method checks where is the collision point in the object and changes
     * the velocity according to the calculation.
     * @param hitter Ball type.
     * @param collisionPoint Point type.
     * @param currentVelocity Velocity type.
     * @return The new velocity after the calculation.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}