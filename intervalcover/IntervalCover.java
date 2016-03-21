/**
* @author Fabian Schilling (fabsch@kth.se)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalCover {


    public static ArrayList<Integer> cover(Interval interval, ArrayList<Interval> intervals) {

        ArrayList<Integer> solution = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.b < o2.b) {
                    return -1;
                } else if (o1.b > o2.b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        double maxRight = interval.a;

        while ((maxRight < interval.b) || (interval.a == interval.b)) {
            int found = -1;

            for (int i = intervals.size() - 1; i >= 0; i--) {

                if (intervals.get(i).a > maxRight) {
                    continue;
                }

                if (intervals.get(i).b < maxRight) {
                    return new ArrayList<>();
                }

                found = i;
                maxRight = intervals.get(i).b;
                break;
            }

            if (found != -1) {
                solution.add(intervals.get(found).index);
                intervals.remove(found);
            } else {
                return new ArrayList<>();
            }

            if (interval.a == interval.b) {
                break;
            }
        }

        if (maxRight < interval.b) {
            return new ArrayList<>();
        }

        return solution;
    }

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in, System.out);

        while (io.hasMoreTokens()) {

            Interval interval = new Interval(io.getDouble(), io.getDouble(), -1);

            int n = io.getInt();

            ArrayList<Interval> intervals = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(io.getDouble(), io.getDouble(), i));
            }

            ArrayList<Integer> solution = cover(interval, intervals);

            if (solution.isEmpty()) {
                io.println("impossible");
            } else {
                io.println(solution.size());
                for (int i = 0; i < solution.size(); i++) {
                    io.print(solution.get(i) + " ");
                }
                io.println();
            }

        }

        io.close();

    }
}
