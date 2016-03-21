/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.Arrays;

public class Hull {

    public double cross(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    public Point[] convexHull(Point[] ps) {

        if (ps.length > 1) {
            int n = ps.length, k = 0;
            Point[] h = new Point[2 * n];

            Arrays.sort(ps);

            // Build lower hull
            for (int i = 0; i < n; i++) {
                while (k >= 2 && cross(h[k - 2], h[k - 1], ps[i]) <= 0) k--;
                h[k++] = ps[i];
            }

            // Build upper hull
            for (int i = n - 2, t = k + 1; i >= 0; i--) {
                while (k >= t && cross(h[k - 2], h[k - 1], ps[i]) <= 0) k--;
                h[k++] = ps[i];
            }

            if (k > 1) {
                h = Arrays.copyOfRange(h, 0, k - 1);
            }
            return h;
        } else if (ps.length <= 1) {
            return ps;
        } else {
            return null;
        }
    }
}
