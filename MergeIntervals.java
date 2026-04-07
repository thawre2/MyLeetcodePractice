import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        // this seems like interval problem and we can solve this in O(nlogn) - sorting + merging
        List<int[]> result = new ArrayList<>();

        // sort the array
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        result.add(intervals[0]);  // add first array in result

        for(int i=1; i<intervals.length; i++) {
            int[] last = result.get(result.size()-1);

            if(last[1] >= intervals[i][0]) {
                last[1] = Math.max(last[1], intervals[i][1]);  // update end of the element if there is any overlap
            } else {
                result.add(intervals[i]);  // directly add it to result if no overlap
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
