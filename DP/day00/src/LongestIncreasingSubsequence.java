public class LongestIncreasingSubsequence {

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
    }
}