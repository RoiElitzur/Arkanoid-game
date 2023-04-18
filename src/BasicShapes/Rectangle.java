package BasicShapes;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the Rectangle class.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    static final int EDGES = 4;
    /**
     * This is a constructor method to initiate a new rectangle object.
     * @param upperLeft Point type.
     * @param width     double type.
     * @param height    double type.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
    }
    /**
     * This method calculates the intersection Points of a line with a rectangle and creates
     * an array of the intersections points.
     *
     * @param line Line type.
     * @return The array list of the intersections points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<Point>();
        Line[] lines = new Line[EDGES];
        lines[0] = this.getTopEdge();
        lines[1] = this.getBottomEdge();
        lines[2] = this.getRightEdge();
        lines[3] = this.getLeftEdge();
        for (int i = 0; i < lines.length; i++) {
            Point intersection = line.intersectionWith(lines[i]);
            if (intersection != null) {
                intersections.add(intersection);
            }
        }
        return intersections;
    }
    /**
     * This is a getter method to get the width of the rectangle.
     * @return double type, the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * This is a getter method to get the height of the rectangle.
     * @return double type, the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * This is a getter method to get the upper left point of the rectangle.
     * @return Point type, the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * This is a getter method to get the line of the top edge of the rectangle.
     * @return Line type.
     */
    public Line getTopEdge() {
        Point start = new Point(this.upperLeft.getX(), this.upperLeft.getY());
        Point end = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        return new Line(start, end);
    }
    /**
     * This is a getter method to get the line of the bottom edge of the rectangle.
     * @return Line type.
     */
    public Line getBottomEdge() {
        Point start = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        Point end = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        return new Line(start, end);
    }
    /**
     * This is a getter method to get the line of the right edge of the rectangle.
     * @return Line type.
     */
    public Line getRightEdge() {
        Point start = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point end = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        return new Line(start, end);
    }
    /**
     * This is a getter method to get the line of the left edge of the rectangle.
     * @return Line type.
     */
    public Line getLeftEdge() {
        Point start = new Point(this.upperLeft.getX(), this.upperLeft.getY());
        Point end = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        return new Line(start, end);
    }
}