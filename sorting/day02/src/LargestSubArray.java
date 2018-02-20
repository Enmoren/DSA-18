import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0, count = 0;
        int startindex =0, endindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                count = count + 1;
            }
            if (nums[i]==0){
                count = count - 1;
            }
            if (map.containsKey(count)) {
                int temp = i - (map.get(count) + 1);
                if (temp >= maxlen){
                    startindex = map.get(count) + 1;
                    endindex = i;
                    maxlen = temp;
                    if (startindex-2>=0 && nums[startindex-1]+nums[startindex-2]==1)
                    {
                        startindex = startindex- 2;
                    }
                }
            } else {
                map.put(count, i);
                if (count == 0){
                    int temp = i ;
                    if (temp >= maxlen){
                        startindex = 0;
                        endindex = i;
                        maxlen = temp;
                        if (startindex-2>=0 && nums[startindex-1]+nums[startindex-2]==1)
                        {
                            startindex = startindex- 2;
                        }
                    }
                }
            }
        }
        int[] subarray ={startindex,endindex};
        return subarray;
    }
}
