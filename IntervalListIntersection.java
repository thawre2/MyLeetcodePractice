import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // this seems like two pointer problem
        List<int[]> result = new ArrayList<>();

        int i=0, j=0;

        while(i<firstList.length && j<secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];

            // check if intersection happening
            if(a[0] <= b[1] && b[0] <= a[1]) {
                int start = Math.max(a[0],b[0]);
                int end = Math.min(a[1],b[1]);
                result.add(new int[]{start,end});
            }

            // advance pointer to next list if the interval is smaller
            if(a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
