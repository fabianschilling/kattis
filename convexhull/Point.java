/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.ArrayList;

public class Point implements Comparable<Point>{

    public static Point ZERO = new Point(0, 0);

    public double x;
    public double y;
    public int index;

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

    public boolean isAboveLine(Line l) {

        Point a = l.a;
        Point b = l.b;
        Point p = this;

        Point ab = b.subtract(a);
        Point ap = p.subtract(a);

        return ab.cross(ap) > 0;
    }

    public static Point computeCentroid(ArrayList<Point> points) {

        Point centroid = new Point(0, 0);
        for (Point p: points) {
            centroid.x += p.x;
            centroid.y += p.y;
        }

        centroid.x /= points.size();
        centroid.y /= points.size();

        return centroid;
    }

    public String toString() {
        return (int) this.x + " " + (int) this.y;
    }

    public int compareTo(Point p) {
        if (this.x == p.x) {
            return this.y - p.y > 0 ? 1: -1;
        } else {
            return this.x - p.x > 0 ? 1: -1;
        }
    }
}
