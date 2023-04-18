package BasicShapes;
import java.util.List;
/**
 * This is the Line class. It has methods that are related to the Line object.
 */
public class Line {
    private Point start;
    private Point end;
    /**
     * This is a constructor method, it initiates the start point and the end point of the line.
     * It uses two points from the main method.
     * @param start point.
     * @param end point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * This is a constructor method, it initiates the start point and the end point of the line.
     * It uses four dots from the main method.
     * @param x1 the x dot of the start point.
     * @param y1 the y dot of the start point.
     * @param x2 the x dot of the end point.
     * @param y2 the y dot of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * This method calculates the length of the line.
     * It uses the distance method from the Point class.
     * @return the length of the line.
     */
    public double length() {
        return (this.start.distance(end));
    }
    /**
     * THis method calculates the middle point of the line.
     * @return temp, the middle point of the line.
     */
    public Point middle() {
        double x1 = (this.start.getX() + this.end.getX()) / 2.0;
        double y1 = (this.start.getY() + this.end.getY()) / 2.0;
        return (new Point(x1, y1));
    }
    /**
     * This is a getter method to get the start point of the line.
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }
    /**
     * This is a getter method to get the end point of the line.
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }
    /**
     * This method calculates the slope of a Point.
     * @return the slope of the point.
     */
    public double slope() {
        if (this.start.getX() == this.end.getX()) {
            return 0;
        }
        return ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
    }
    /**
     *This method checks if both lines have the same line equation.
     * ig they have, it checks if there is overlap between the lines.
     * @param other Line type.
     * @return the intersection points if there is an intersection point, else null.
     */
    public Point isSameEquation(Line other) {
        //checks if both lines have the same equation.
        if (this.slope() * this.start.getX() + this.start.getY()
                == this.slope() * this.start.getX() + this.start.getY()) {
            // checks if there is an overlap
            if ((this.start.getX() > Math.min(other.start.getX(), other.end.getX())
                    && this.start.getY() > Math.min(other.start.getY(), other.end.getY()))
                    && (this.start.getX() < Math.max(other.start.getX(), other.end.getX())
                    && this.start.getY() < Math.max(other.start.getY(), other.end.getY()))) {
                return this.start;
            }
            // checks if there is an overlap
            if ((this.end.getX() > Math.min(other.start.getX(), other.end.getX())
                    && this.end.getY() > Math.min(other.start.getY(), other.end.getY()))
                    && (this.end.getX() < Math.max(other.start.getX(), other.end.getX())
                    && this.end.getY() < Math.max(other.start.getY(), other.end.getY()))) {
                return this.end;
            }
            // checks if there is an overlap
            if ((other.start.getX() > Math.min(this.start.getX(), this.end.getX())
                    && other.start.getY() > Math.min(this.start.getY(), this.end.getY()))
                    && (other.start.getX() < Math.max(this.start.getX(), this.end.getX())
                    && other.start.getY() < Math.max(this.start.getY(), this.end.getY()))) {
                return other.start;
            }
            // checks if there is an overlap
            if ((other.end.getX() > Math.min(this.start.getX(), this.end.getX())
                    && other.end.getY() > Math.min(this.start.getY(), this.end.getY()))
                    && (other.end.getX() < Math.max(this.start.getX(), this.end.getX())
                    && other.end.getY() < Math.max(this.start.getY(), this.end.getY()))) {
                return other.end;
            }
        }
        return null;
    }
    /**
     * This method calculates the intersection point between two lines.
     * @param other Line type.
     * @return temp, the intersection point.
     */
    public Point getIntersection(Line other) {
        if (other == null) {
            return null;
        }
        //Uses the equals method.
        if (this.equals(other)) {
            return this.start;
        }
        //Uses the contained method.
        if (this.contained(other)) {
            return this.middle();
        }
        if (!this.isVertical() && !other.isVertical()) {
            if (this.slope() == 0 && other.slope() != 0) {
                double y = this.start.getY();
                //double freeFirst = -(this.slope() * this.start.getX()) + this.start.getY();
                double freeSecond = -(other.slope() * other.start.getX()) + other.start.getY();
                double x = (this.start.getY() - freeSecond) / other.slope();
                return new Point(x, y);
            }
            if (this.slope() != 0 && other.slope() == 0) {
                double y = other.start.getY();
                double freeFirst = -(this.slope() * this.start.getX()) + this.start.getY();
                //double freeSecond = -(other.slope() * other.start.getX()) + other.start.getY();
                double x = (other.start.getY() - freeFirst) / this.slope();
                return new Point(x, y);
            }
        }
        if (this.isVertical() && other.slope() == 0) {
            double x = this.start.getX();
            double y = other.start.getY();
            return new Point(x, y);
        }
        if (other.isVertical() && this.slope() == 0) {
            double x = other.start.getX();
            double y = this.start.getY();
            return new Point(x, y);
        }
        double slopeFirst = this.slope();
        double slopeSecond = other.slope();
        // checks if one of the border points intersects the other line.
        if (this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY()
                || this.start.getX() == other.end.getX() && this.start.getY() == other.end.getY()) {
            return this.start;
        }
        if (this.end.getX() == other.start.getX() && this.end.getY() == other.start.getY()
                || this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY()) {
            return this.end;
        }
        // checks if there is an overlap between two lines that has the same slope.
        if (slopeFirst == slopeSecond && !this.isVertical() && !other.isVertical()) {
            //checks if both lines have the same equation.
            if (this.slope() * this.start.getX() + this.start.getY()
                    == this.slope() * this.start.getX() + this.start.getY()) {
                //checks if there is an overlap
                if ((this.start.getX() > Math.min(other.start.getX(), other.end.getX())
                        && this.start.getY() > Math.min(other.start.getY(), other.end.getY()))
                        && (this.start.getX() < Math.max(other.start.getX(), other.end.getX())
                        && this.start.getY() < Math.max(other.start.getY(), other.end.getY()))) {
                    return this.start;
                }
                //checks if there is an overlap
                if ((this.end.getX() > Math.min(other.start.getX(), other.end.getX())
                        && this.end.getY() > Math.min(other.start.getY(), other.end.getY()))
                        && (this.end.getX() < Math.max(other.start.getX(), other.end.getX())
                        && this.end.getY() < Math.max(other.start.getY(), other.end.getY()))) {
                    return this.end;
                }
                //checks if there is an overlap
                if ((other.start.getX() > Math.min(this.start.getX(), this.end.getX())
                        && other.start.getY() > Math.min(this.start.getY(), this.end.getY()))
                        && (other.start.getX() < Math.max(this.start.getX(), this.end.getX())
                        && other.start.getY() < Math.max(this.start.getY(), this.end.getY()))) {
                    return other.start;
                }
                //checks if there is an overlap
                if ((other.end.getX() > Math.min(this.start.getX(), this.end.getX())
                        && other.end.getY() > Math.min(this.start.getY(), this.end.getY()))
                        && (other.end.getX() < Math.max(this.start.getX(), this.end.getX())
                        && other.end.getY() < Math.max(this.start.getY(), this.end.getY()))) {
                    return other.end;
                }
            }
            return null;
        }
        //checks for an intersection between two vertical lines.
        if (this.isVertical() && other.isVertical()) {
            if (this.start.getX() != other.start.getX()) {
                return null;
            }
            return null;
        }
        //checks for an intersection between a vertical line and sloping line.
        if (this.isVertical() && !other.isVertical()) {
            double check = other.slope() * this.start.getX() - other.slope() * other.start.getX() + other.start.getY();
            if (check <= Math.max(this.start.getY(), this.end.getY())
                    && check >= Math.min(this.start.getY(), this.end.getY())) {
                if (this.start().getX() < Math.min(other.start.getX(), other.end.getX())
                || this.start.getX() > Math.max(other.start.getX(), other.end.getX())) {
                    return null;
                }
                return new Point(this.start.getX(), check);
            }
        }
        //checks for an intersection between a vertical line and sloping line.
        if (!this.isVertical() && other.isVertical()) {
            double check = this.slope() * other.start.getX() - this.slope() * this.start.getX() + this.start.getY();
            if (check <= Math.max(other.start.getY(), other.end.getY())
                    && check >= Math.min(other.start.getY(), other.end.getY())) {
                if (other.start().getX() < Math.min(this.start.getX(), this.end.getX())
                        || other.start.getX() > Math.max(this.start.getX(), this.end.getX())) {
                    return null;
                }
                return new Point(other.start.getX(), check);
            }
        }
            //calculates the lines equations and the intersection point.
            double freeFirst = -(this.slope() * this.start.getX()) + this.start.getY();
            double freeSecond = -(other.slope() * other.start.getX()) + other.start.getY();
            double xSect = (freeSecond - freeFirst) / (slopeFirst - slopeSecond);
            double ySect = slopeFirst * xSect + freeFirst;
            return (new Point(xSect, ySect));
        }
    /**
     * This method checks if the intersection point is on the segment lines or not.
     * @param other , Line type
     * @return true if the intersection point in on the lines, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (this.equals(other)) {
            return true;
        }
        if (this.contained(other)) {
            return true;
        }
        if (this.isVertical() && other.isVertical()) {
            if (this.start.getX() != other.start.getX()) {
                return false;
            }
        }
        if (this.isVertical() && !other.isVertical()) {
            double check = other.slope() * this.start.getX() - other.slope() * other.start.getX() + other.start.getY();
            if (check <= Math.max(this.start.getY(), this.end.getY())
            && check >= Math.min(this.start.getY(), this.end.getY())) {
                return true;
            }
            return false;
        }
        if (other.isVertical() && !this.isVertical()) {
            double check = this.slope() * other.start.getX() - this.slope() * this.start.getX() + this.start.getY();
            if (check <= Math.max(other.start.getY(), other.end.getY())
                    && check >= Math.min(other.start.getY(), other.end.getY())) {
                return true;
            }
            return false;
        }
        Point intersection = this.getIntersection(other);
        if (intersection == null) {
            return false;
        }
        // checks if the intersection point is the range of the segments lines.
        if ((intersection.getX() > this.start.getX() && intersection.getX() > this.end.getX())
                || (intersection.getX() < this.start.getX() && intersection.getX() < this.end.getX())
                || (intersection.getX() > other.start.getX() && intersection.getX() > other.end.getX())
                || (intersection.getX() < other.start.getX() && intersection.getX() < other.end.getX())
                || (intersection.getY() > this.start.getY() && intersection.getY() > this.end.getY())
                || (intersection.getY() < this.start.getY() && intersection.getY() < this.end.getY())
                || (intersection.getY() > other.start.getY() && intersection.getY() > other.end.getY())
                || (intersection.getY() < other.start.getY() && intersection.getY() < other.end.getY())) {
            return false;
        }
        return true;
    }
    /**
     * This method checks the line is vertical.
     * @return true if it is vertical, otherwise false.
     */
    public boolean isVertical() {
        if (this.start.getX() == this.end.getX()) {
            return true;
        }
        return false;
    }
    /**
     * This method returns the intersection point if the lines intersect,
     * otherwise returns null.
     * @param other Line type.
     * @return the intersection point or null.
     */
    public Point intersectionWith(Line other) {
        if (other == null) {
            return null;
        }
        if (!this.isIntersecting(other)) {
        return null;
    }
        if (this.equals(other)) {
            return null;
        }
        if (this.contained(other)) {
            return null;
        }
        if (this.slope() == other.slope()) {
            if (this.isSameEquation(other) != null) {
                return null;
            }
        }
        return this.getIntersection(other);
    }
    /**
     * This method checks if the Lines are equal.
     * @param other Line type.
     * @return true if they are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (((this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY())
                && (this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY()))
                || ((this.start.getX() == other.end.getX() && this.start.getY() == other.end.getY())
                && (this.end.getX() == other.start.getX() && this.end.getY() == other.start.getY()))) {
            return true;
        }
        return false;
    }
    /**
     * This method checks if a line contain another line.
     * @param other Line type.
     * @return true if one of the lines contain the other, false otherwise.
     */
    public boolean contained(Line other) {
        double slopeFirst = this.slope();
        double slopeSecond = other.slope();
        if (slopeFirst != slopeSecond) {
            return false;
        }
        //checks if the first line is in the range of the second line.
        if ((Math.min(this.start.getX(), this.end.getX()) >= Math.min(other.start.getX(), other.end.getX()))
                && (Math.max(this.start.getX(), this.end.getX()) <= Math.max(other.start.getX(), other.end.getX()))
                && (Math.min(this.start.getY(), this.end.getY()) >= Math.min(other.start.getY(), other.end.getY()))
                && (Math.max(this.start.getY(), this.end.getY()) <= Math.max(other.start.getY(), other.end.getY()))) {
            return true;
        }
        //checks if the second line is in the range of the first line.
        if ((Math.min(this.start.getX(), this.end.getX()) <= Math.min(other.start.getX(), other.end.getX()))
                && (Math.max(this.start.getX(), this.end.getX()) >= Math.max(other.start.getX(), other.end.getX()))
                && (Math.min(this.start.getY(), this.end.getY()) <= Math.min(other.start.getY(), other.end.getY()))
                && (Math.max(this.start.getY(), this.end.getY()) >= Math.max(other.start.getY(), other.end.getY()))) {
            return true;
        }
        return false;
    }
    /**
     * This method gets an array list of the intersections points and checks
     * which point is the closets point to the line.
     * @param rect Rectangle type.
     * @return Point type, the closets point after the calculation.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersections = rect.intersectionPoints(this);
        if (intersections.isEmpty()) {
            return null;
        }
        Point closest = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        for (int i = 0; i < intersections.size(); i++) {
            Point temp = new Point(intersections.get(i).getX(), intersections.get(i).getY());
            if (this.start.distance(temp) < this.start.distance(closest)) {
                closest = temp;
            }
        }
        return closest;
}
}
