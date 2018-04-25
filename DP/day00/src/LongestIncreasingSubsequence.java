public class LongestIncreasingSubsequence {

<<<<<<< HEAD
    // Runtime: N^2
    // Space: N
    public static int LIS(int[] A) {

        if(A.length <= 1)
            return A.length;

        int array[] = new int[A.length];
        for(int i=0; i < A.length; i++)
            array[i] = 1;

        for(int i=1; i < A.length; i++)
        {
            for(int j=0; j < i; j++)
            {
                if(A[j] < A[i])
                {
                    if(array[j] + 1 > array[i])
                    {
                        array[i] = array[j] + 1;
                    }
                }
            }
        }

        int longest = 0;
        for(int i=0; i < array.length; i++)
            longest = Math.max(longest, array[i]);

        return longest;
=======
    // Runtime: TODO
    // Space: TODO
    public static int LIS(int[] A) {
        // TODO
        return 0;
>>>>>>> 84f81784b5484b283d38d8900f42a8955698ad97
    }
}