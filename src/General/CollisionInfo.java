package General;
import BasicShapes.Point;
import Interfaces.Collidable;
/**
 * This is the CollisionInfo class.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * This is a constructor method to initiate a collision info object.
     * @param collisionPoint Point type.
     * @param collisionObject Collidable type.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * This method returns the collision point.
     * @return the collision point, Point tyoe.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * This method returns the collidable object involved in the collision.
     * @return The collision object Collidable type.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}