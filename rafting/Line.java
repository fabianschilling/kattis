/**
* @author Fabian Schilling (fabsch@kth.se)
*/

public class Line {

    public Point a;
    public Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    /* TESTED AND WORKS*/
    public double distanceToLineSegment(Line l) {

        // Line segments ab and cd
        Point a = this.a;
        Point b = this.b;
        Point c = l.a;
        Point d = l.b;

        // If they intersect then the distance is zero
        if (this.doesIntersect(l)) {
            return 0.0;
        }

        // Compute all possible point to line segment distances
        double[] distances = new double[4];
        distances[0] = this.distanceToPoint(c);
        distances[1] = this.distanceToPoint(d);
        distances[2] = l.distanceToPoint(a);
        distances[3] = l.distanceToPoint(b);

        // Find the minimum distance
        double min = Double.MAX_VALUE;
        for (double dist: distances) {
            if (dist < min) {
                min = dist;
            }
        }

        return min;
    }

    /* TESTED AND WORKS */
    public boolean doesIntersect(Line l) {

        // Line segments ab and cd
        Point a = this.a;
        Point b = this.b;
        Point c = l.a;
        Point d = l.b;

        // Get vectors from origin
        Point e = b.subtract(a);
        Point f = d.subtract(c);

        // Cross origin vectors
        double x = f.cross(e);

        // ab and cd are parallel
        if (x == 0.0) {
            return false;
        }

        // Check for intersection
        double y = (e.x * (c.y - a.y) + e.y * (a.x - c.x)) / x;
        double z = (f.x * (a.y - c.y) + f.y * (c.x - a.x)) / -x;

        // Check if in range [0, 1], i.e. intersection on the line segment
        return 0.0 <= y && y <= 1.0 && 0.0 <= z && z <= 1.0;
    }

    /* TESTED AND WORKS */
    public double distanceToPoint(Point p) {

        // Line segment ab
        Point a = this.a;
        Point b = this.b;

        // Get vector from origin
        Point d = b.subtract(a);

        // The segment is just a point
        if (d.equals(Point.ZERO)) {
            return p.subtract(a).length();
        }

        // Calculate x that minimized the distance
        double x = p.subtract(a).dot(d) / d.dot(d);

        // See if this represents a point on the edge or middle
        if (x < 0.0) {
            return p.subtract(a).length();
        } else if (x > 1.0) {
            return p.subtract(b).length();
        } else {
            return p.subtract(a.add(d.multiply(x))).length();
        }
    }

}
