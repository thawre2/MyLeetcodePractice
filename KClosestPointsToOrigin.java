import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // This seems like a max heap problem because we need to return k closest origin points

        // declare max heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1])
        );


        // add points to heap
        for(int[] point : points) {
            maxHeap.add(point);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // process heap for result
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) {
            result[i] = maxHeap.poll();
        }


        // return result
        return result;
    }

    // time complexity: O(nlogk)
    // space complexity: O(n)
}
