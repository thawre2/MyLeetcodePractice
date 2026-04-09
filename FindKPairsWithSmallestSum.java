import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0]-b[0]);

        for(int i=0; i<nums1.length && i<k; i++) {
            minHeap.offer(new int[]{nums1[i]+nums2[0], i, 0});
        }

        while(k > 0) {
            int[] curr = minHeap.poll();

            int i = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if(j+1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i]+nums2[j+1], i, j+1});
            }

            k--;
        }

        return result;
    }
}
