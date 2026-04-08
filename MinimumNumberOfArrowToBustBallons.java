import java.util.Arrays;

public class MinimumNumberOfArrowToBustBallons {
    public int findMinArrowShots(int[][] points) {
        // This seem like an interval problem, we can solve this problem by first sort array by end in O(nlogn) time

        Arrays.sort(points, (a, b)->Integer.compare(a[1],b[1]));

        int arrowCount = 1; // initialize arrow count to 1 as this is the minimum number of arrow req
        int end = points[0][1]; // initialize end with first point end

        for(int i=1; i<points.length; i++) {
            if(points[i][0] > end) {
                arrowCount++;
                end = points[i][1];
            }
        }

        return arrowCount;
    }
}
