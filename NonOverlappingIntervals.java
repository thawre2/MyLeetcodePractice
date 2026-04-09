import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // this seem like an interval problem which can we solved by sorting the array by end first and then keep track of the overlap intervals

        // sort intervals by end
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);

        int lastEnd = intervals[0][1];
        int removed = 0;

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < lastEnd) {
                // if overlap then remove, and keep track of lastEnd before removal
                removed++;
            } else {
                // update lastEnd
                lastEnd = intervals[i][1];
            }
        }

        return removed;
    }
}
