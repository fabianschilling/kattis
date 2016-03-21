/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static IO io = new IO(System.in, System.out);
    //public static IO io = new IO("/Users/fabianschilling/Downloads/samples/segmentdistance_sample.in");
    //public static IO io = new IO("/Users/fabianschilling/Downloads/samples/convexhull_sample.in");

    public static void main(String[] args) {

        convexHull();
        //segmentDistance();

    }

    public static void convexHull() {

        while (io.hasMoreTokens()) {

            int n = io.getInt();
            if (n == 0) break;

            Point[] points = new Point[n];

            for (int i = 0; i < n; i++) {
                points[i] = new Point(io.getDouble(), io.getDouble());
            }

            Point[] hull = new Hull().convexHull(points);

            // Remove collinear edges
            ArrayList<Point> finalHull = new ArrayList<>();
            for (int i = 0; i < hull.length - 1; i++) {
                if (hull[i].subtract(hull[i + 1]).equals(Point.ZERO)) {
                    continue;
                }
                finalHull.add(hull[i]);
            }
            finalHull.add(hull[hull.length - 1]);

            io.println(finalHull.size());

            for (Point p: finalHull) {
                io.println(p);
            }

        }

        io.close();
    }

    public static void segmentDistance() {

        int n = io.getInt(); // n <= 10000

        for (int i = 0; i < n; i++) {
            Point a = new Point(io.getDouble(), io.getDouble());
            Point b = new Point(io.getDouble(), io.getDouble());
            Line l1 = new Line(a, b);

            Point c = new Point(io.getDouble(), io.getDouble());
            Point d = new Point(io.getDouble(), io.getDouble());
            Line l2 = new Line(c, d);

            io.println(String.format("%.2f", l1.distanceToLineSegment(l2)));
        }

        io.close();
    }
}
