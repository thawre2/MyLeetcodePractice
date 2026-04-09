import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b)->a[0]-b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int maxDay = 0;
        for(int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        int i=0;
        int count=0;
        int n = events.length;

        for(int day=1; day<=maxDay; day++) {
            while(i<n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()<day) {
                minHeap.poll();
            }

            if(!minHeap.isEmpty()) {
                minHeap.poll();
                count++;
            }
        }

        return count;
    }
}
