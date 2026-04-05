import java.util.PriorityQueue;

public class ProcessTasksUsingServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // freeHeap: (weight, index)
        PriorityQueue<int[]> freeHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        // busyHeap: (freeTime, weight, index)
        PriorityQueue<int[]> busyHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] :
                        a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]
        );

        // add all servers to freeHeap
        for (int i = 0; i < servers.length; i++) {
            freeHeap.offer(new int[]{servers[i], i});
        }

        int[] result = new int[tasks.length];
        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            // free servers that are done by current time
            while (!busyHeap.isEmpty() &&
                    busyHeap.peek()[0] <= time) {
                int[] server = busyHeap.poll();
                freeHeap.offer(new int[]{server[1], server[2]});
            }

            // no free server → jump to earliest free time
            if (freeHeap.isEmpty()) {
                int[] earliest = busyHeap.poll();
                time = earliest[0]; // jump time!
                freeHeap.offer(new int[]{earliest[1], earliest[2]});

                // free any other servers that become free at same time
                while (!busyHeap.isEmpty() &&
                        busyHeap.peek()[0] <= time) {
                    int[] server = busyHeap.poll();
                    freeHeap.offer(new int[]{server[1], server[2]});
                }
            }

            // assign best free server to task
            int[] best = freeHeap.poll();
            result[i] = best[1]; // server index
            busyHeap.offer(new int[]{
                    time + tasks[i], // freeTime
                    best[0],         // weight
                    best[1]          // index
            });
        }

        return result;
    }
}
