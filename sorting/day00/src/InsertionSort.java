
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: O(N) Insert element in a sorted array
     * Worst-case runtime: O(N^2) Array in reversed order
     * Average-case runtime: O(N^2)
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] arr) {
        int p = 0;
        for (int i = 1; i < arr.length; ++i){
            p = i-1;
            while (p>=0 && arr[p] > arr[p + 1]) {
                int temp = arr[p];
                arr[p] = arr[p + 1];
                arr[p + 1] = temp;
                p = p - 1;
            }
        }
        return arr;
    }
}
