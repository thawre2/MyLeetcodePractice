import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
//        Algorithm:
//        1. sort array by enqueue time
//        2. use min heap (processing time, index)
//            Simulate time :
//                - add tasks available at the current time in heap
//                - if there are no tasks in the current time then move to the next available time
//                - advance time to current time + processing time
//                - repeat

        // find length of the tasks
        int n = tasks.length;

        // create indexed array to maintain original index of task
        int[][] indexedTasks = new int[n][2];

        for(int i = 0; i < n; i++){
            indexedTasks[i][0] = tasks[i][0]; // enqueue time
            indexedTasks[i][1] = tasks[i][1]; // processing time
            indexedTasks[i][0] = i;           // original index
        }

        Arrays.sort(indexedTasks, (a, b)-> a[0]-b[0]);

        // min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        int[] result = new int[n];
        long time = 0;  // enqueueTime and processingTime can be up to 10^9 n can be up to 10^5
        int taskIndex = 0;
        int resultIndex = 0;

        while(resultIndex < n) {
            while(taskIndex < n && indexedTasks[taskIndex][0] <= time){
                minHeap.offer(new int[]{indexedTasks[taskIndex][1], indexedTasks[taskIndex][2]});
                taskIndex++;
            }

            // if the heap is empty then go to next enqueue time
            if(minHeap.isEmpty()){
                time = indexedTasks[taskIndex][0];
                continue;
            }

            // process time
            int[] task = minHeap.poll();
            result[resultIndex++] = task[1];
            time += task[0];
        }

        return result;
    }
}
