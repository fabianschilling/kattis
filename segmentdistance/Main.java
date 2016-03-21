/**
* @author Fabian Schilling (fabsch@kth.se)
*/

public class Main {

    public static IO io = new IO(System.in, System.out);
    //public static IO io = new IO("/Users/fabianschilling/Downloads/samples/segmentdistance_sample.in");

    public static void main(String[] args) {

        segmentDistance();
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
