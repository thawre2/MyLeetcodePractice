import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        // this seems like a bucket sort problem
        Map<Integer,Integer> freqMap = new HashMap<>();

        // step 1: count frequencies
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        // bucket sort - buckets
        List<Integer>[] buckets = new List[nums.length+1];

        // stpe 2: store elements in their frequency bucket
        for(int num : freqMap.keySet()) {
            int freq = freqMap.get(num);

            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // step 3: collect top k from highest frequency bucket
        int[] result = new int[k];
        int index = 0;
        for(int i=nums.length; i>=1 && index < k; i--) {
            if(buckets[i] != null) {
                for(int num : buckets[i]) {
                    result[index++] = num;
                }
            }
        }

        return result;
    }

    // time complexity: O(n)
    // space complexity: O(n)
}
