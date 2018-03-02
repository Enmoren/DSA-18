import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingSort {

    /**
<<<<<<< HEAD
     * Use counting sort to sort positive integer array A.
     * Runtime: O (N+K)
     * Space Complexity: ?
     * n: number of elements in the list
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
     *
>>>>>>> 36d97f25cf2f04bab6968f6738ddb01e54578262
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        int [] count = new int[max+1];
        for (int i = 0; i < A.length; i++) {
            int index = A[i];
            count[index]++;
        }
//        for (int val: A){
//            count[val]++;
//        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int count1 = count[i];
            for (int j = 0; j < count1; j++) {
                A[index] = i;
                index++;
            }
        }
    }

}
