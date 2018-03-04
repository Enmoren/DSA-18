import java.util.Arrays;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        int low = 0;
        int high = nums.length;
        while (high != low){
            int mid = (high + low)/2;
            if (mid == 0||peakOneD(mid,nums)==0)
                return mid;
            else if (peakOneD(mid,nums)==-1)
                high = mid;
            else if (peakOneD(mid,nums)== 1)
                low = mid;
        }
        return 0;
    }

    public static int[] findTwoDPeak(int[][] nums) {

        int left = 0;
        int right = nums.length;
        int top = 0;
        int bottom = nums.length;
        int counter = 0;
        while (right>left && bottom>top) {
            int mid_col = (left + right) / 2;
            int mid_row = (top + bottom) / 2;
            if (counter % 2 == 0) {
                int peak_col = maxYIndex(mid_col, top, bottom, nums);
                if (peakX(mid_col, peak_col, nums) == 0) {
                    int[] res = {peak_col, mid_col};
                    return res;
                } else if (peakX(mid_col, peak_col, nums)==-1) {
                    right = mid_col;
                } else {
                    left = mid_col;
                }
            } else {
                int peak_row = maxXIndex(mid_row, left, right, nums);
                if (peakY(peak_row, mid_row, nums) == 0) {
                    int[] res = {mid_row, peak_row};
                    return res;
                } else if (peakY(peak_row,mid_row, nums) == -1) {
                    bottom = mid_row;
                } else {
                    top = mid_row;
                }
            }
            counter++;
        }
        return new int[] {0,0};
    }

}
