
public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
<<<<<<< HEAD
     * Best-case runtime: O(n log n)
     * Worst-case runtime:O(n log n)
     * Average-case runtime:O(n log n)
     *
     * Space-complexity:O(N)
     */

    @Override
    public int[] sort(int[] arr) {
        int mid = arr.length/2;
        if (arr.length<=1)
            return arr;
        int left[] = new int[mid];
        int right[] = new int[arr.length-mid];
        System.arraycopy(arr,0,left,0,mid);
        System.arraycopy(arr,mid,right,0,arr.length-mid);
        return merge(sort(left),sort(right));
        }

    public int[] insertionsort(int[] arr) {
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
=======
     * TODO
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        return new int[0];
    }

>>>>>>> 8b27a4e8a67573005ee1bc7871daf23fb550f8c1
    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
<<<<<<< HEAD
        int length = a.length+b.length;
        int merge[] = new int [length];
        int aindex = 0;
        int bindex = 0;
        int index = 0;
        if (length<INSERTION_THRESHOLD){
            System.arraycopy(a, 0, merge, 0, a.length);
            System.arraycopy(b, 0, merge, a.length, b.length);
            insertionsort(merge);
        }
        for (int i = 0; i < length; i++) {
            index = i;
            if (a.length == 0)
                return b;
            if (b.length == 0)
                return a;
            if (a[aindex]<=b[bindex]){
                merge[i] = a[aindex++];
            }
            else{ merge[i] = b[bindex++]; }
            if(bindex>b.length-1){
                break;
            }
            if(aindex>a.length-1){
                break;
            }
        }
        for (int i = index+1; i < length; i++) {
            if(bindex>b.length-1){
                merge[i] = a[aindex];
                aindex++;
            }
            else{
                merge[i] = b[bindex];
                bindex++;
            }
        }
        return merge;
=======
        // TODO
        return new int[0];
>>>>>>> 8b27a4e8a67573005ee1bc7871daf23fb550f8c1
    }

}
