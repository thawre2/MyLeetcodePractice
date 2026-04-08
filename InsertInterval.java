import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // This seem like an interval problem which can be solved in O(n) time, as the given array is already sorted. We will solve this problem in three phases
        // 1. add intervals that comes before newIntervals (no overlap)
        // 2. add intervals that overlap with newInterval (overlap -> yes -> merge)
        // 3. add intervals after newInterval

        List<int[]> result = new ArrayList<>();

        int n = intervals.length; // length of intervals

        int i=0;

        // phase 1: add all intervals before newInterval
        while(i<n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // phase 2: overlap with newInterval
        while(i<n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // phase 3: add all elements after newInterval
        while(i<n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
