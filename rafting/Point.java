/**
* @author Fabian Schilling (fabsch@kth.se)
*/


public class Point {

    public static Point ZERO = new Point(0, 0);

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point p) {
        return new Point(this.x + p.x, this.y + p.y);
    }

    public Point add(double d) {
        return new Point(this.x + d, this.y + d);
    }

    public Point subtract(Point p) {
        return new Point(this.x - p.x, this.y - p.y);
    }

    public Point subtract(double d) {
        return new Point(this.x - d, this.y - d);
    }

    public Point multiply(double d) {
        return new Point(this.x * d, this.y * d);
    }

    public Point divide(double d) {
        return new Point(this.x / d, this.y / d);
    }

    // also: scalar product, innter product
    public double dot(Point p) {
        return this.x * p.x + this.y * p.y;
    }

    public double cross(Point p) {
        return this.x * p.y - this.y * p.x;
    }

    public double distanceToPoint(Point p) {
        double d1 = Math.abs(this.x - p.x);
        double d2 = Math.abs(this.y - p.y);
        return Math.sqrt(d1 * d1 + d2 * d2);
    }

    public double length() {
        return Math.hypot(this.x, this.y);
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Point) {
            Point that = (Point) o;
            result = (this.x == that.x && this.y == that.y);
        }
        return result;
    }
}
