package General;
import Interfaces.Collidable;
import BasicShapes.Point;
import BasicShapes.Line;
import java.util.ArrayList;
/**
 * This is the GameEnvironment class.
 */
public class GameEnvironment {
    private ArrayList<Collidable> collidables;
    /**
     * This is constructor method to initiate a GameEnvironment object.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }
    /**
     * This method adds the given collidable to the environment.
     * @param c Collidable type.
     */
    public void addCollidable(Collidable c) {
        if (collidables == null) {
            collidables = new ArrayList<Collidable>();
        }
        this.collidables.add(c);
    }
    /**
     * This method removes the given collidable from the environment.
     * @param c Collidable type.
     */
    public void removeCollidable(Collidable c) {
        if (this.collidables != null) {
            this.collidables.remove(c);
        }
    }
    /**
     * This is a getter method the get the Collidables array list.
     * @return the Collidables array list.
     */
    public ArrayList<Collidable> getCollidables() {
        return this.collidables;
    }
    /**
     * This method Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory Line type.
     * @return The closest collision, Point type, or null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.collidables.isEmpty()) {
            return null;
        }
        Point closest = null;
        int saveCollodableIndex = 0;
        int i = 0;
        while (closest == null && i < collidables.size()) {
            Point temp = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
            if (temp != null) {
                closest = temp;
                saveCollodableIndex = i;
            }
            i++;
        }
        if (closest != null) {
            for (int j = 0; j < collidables.size(); j++) {
                Point temp = trajectory.closestIntersectionToStartOfLine(collidables.get(j).getCollisionRectangle());
                if (temp != null) {
                    double distTemp = trajectory.start().distance(temp);
                    double distClosest = trajectory.start().distance(closest);
                    if (distTemp < distClosest) {
                        closest = temp;
                        saveCollodableIndex = j;
                    }
                }
            }
        }
            if (closest != null) {
                return new CollisionInfo(closest, collidables.get(saveCollodableIndex));
            }
            return null;
    }
}