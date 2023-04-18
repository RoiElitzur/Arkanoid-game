package BasicShapes;
/**
 * This is the Velocity class, Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * This is a constructor method for Velocity types.
     * @param dx the change in x.
     * @param dy the change in y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * This method using the velocity values to apply the ball from one point
     * to the next point.
     * @param p a given point, where the ball is right now.
     * @return the new point after the velocity changes.
     */
    public Point applyToPoint(Point p) {
        return (new Point((p.getX() + this.dx), (p.getY() + this.dy)));
    }
    /**
     * This method uses the angle and the speed arguments to calculate the wanted velocity.
     * It uses sin and cos from the Math library.
     * @param angle double type.
     * @param speed double type.
     * @return the wanted velocity, Velocity type.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * -Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    /**
     * This is a getter method for getting the dx of the velocity.
     * @return the dx, double type.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * This is a getter method for getting the dy of the velocity.
     * @return the dy, double type.
     */
    public double getDy() {
        return this.dy;
    }
}