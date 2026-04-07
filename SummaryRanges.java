import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        // check for length 0
        if(nums.length == 0) return result;

        int n = nums.length;  // length of array
        int i=0;

        while(i < n) {
            int start = nums[i];  // store start of range

            while(i+1 < n && nums[i]+1 == nums[i+1]) {
                i++;  // if the element is less than array length and continuous the continue
            }

            if(start == nums[i]) {
                result.add(String.valueOf(start));  // for single element
            } else {
                result.add(start + "->" + nums[i]);  // for range
            }
            i++;
        }

        return result;
    }
}
