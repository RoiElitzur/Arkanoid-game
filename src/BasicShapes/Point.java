package BasicShapes;
/**
 * This is the Point class. It has methods that are related to the Point object.
 */
public class Point {
    static final double ERROR = Math.pow(10, -10);
    private double x;
    private double y;

    /**
     * This is a constructor method. It initiates the numbers of the point.
     *
     * @param x the x dot of the coordinate.
     * @param y the y dot of the coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * This method calculates the distance between this point to the other point.
     * @param other point.
     * @return result.
     */
    public double distance(Point other) {
        return (Math.sqrt((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y)));
    }
    /**
     * This method compares between two points if thew are equal.
     * @param other a Point type.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return Math.abs(this.x - other.getX()) < ERROR && Math.abs(this.y - other.getY()) < ERROR;
    }
    /**
     * This is a getter method to get the x dot of the point.
     *
     * @return the x value of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * This is a getter method to get the y dot of the point.
     *
     * @return the y value of the point.
     */
    public double getY() {
        return this.y;
    }
    /**
     * This id a setter method for setting the x of a point.
     *
     * @param x double type.
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * This id a setter method for setting the y of a point.
     *
     * @param y double type.
     */
    public void setY(double y) {
        this.y = y;
    }
}