/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.LinkedList;

public class Main {

    public static IO io = new IO(System.in, System.out);

    public static void main(String[] args) {

        int testcases = io.getInt();

        for (int testcase = 0; testcase < testcases; testcase++) {

            // Get all inner points and construc all inner segments
            int numInner = io.getInt();
            Point[] innperPoints = new Point[numInner];
            for (int i = 0; i < numInner; i++) {
                innperPoints[i] = new Point(io.getDouble(), io.getDouble());
            }

            // Get all outer points
            int numOuter = io.getInt();
            Point[] outerPoints = new Point[numOuter];
            for (int i = 0; i < numOuter; i++) {
                outerPoints[i] = new Point(io.getDouble(), io.getDouble());
            }

            // Construct ALL inner line segments
            Line[] innerSegments = new Line[numInner];
            innerSegments[numInner - 1] = new Line(innperPoints[0], innperPoints[numInner - 1]);
            for (int i = 0; i < numInner - 1; i++) {
                innerSegments[i] = new Line(innperPoints[i], innperPoints[i + 1]);
            }

            // Construct ALL outer line segments
            Line[] outerSegments = new Line[numOuter];
            outerSegments[numOuter - 1] = new Line(outerPoints[0], outerPoints[numOuter - 1]);
            for (int i = 0; i < numOuter - 1; i++) {
                outerSegments[i] = new Line(outerPoints[i], outerPoints[i + 1]);
            }

            // Find the minimum distance between all outer and inner segments
            double minDistance = Double.MAX_VALUE;
            for (Line outer: outerSegments) {
                for (Line inner: innerSegments) {
                    double distance = outer.distanceToLineSegment(inner);
                    if (distance < minDistance) {
                        minDistance = distance;
                    }
                }
            }

            io.println(minDistance / 2.0); // asked for radius -> 1/2
        }
        
        io.close();
    }
}
