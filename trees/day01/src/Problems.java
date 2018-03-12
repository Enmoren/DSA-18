public class Problems {

    public static int leastSum(int[] A) {
        //counting sort O(N)
        int[] counts = new int[10];
        for (int digit : A) {
            counts[digit]++;
        }

        int i = 0;
        for (int j=9; j>=0; j--) {
            while (counts[j]>0) {
                A[i] = j;
                counts[j]--;
                i++;
            }
        }

        i = 0;
        int result = 0;
        int multiplier = 1;
        boolean nextDigit = false;
        //go through the array
        while (i<A.length) {
            result = result + multiplier * A[i];
            if (nextDigit == true) {
                multiplier = multiplier * 10;
                nextDigit = false;
            } else {
                nextDigit = true;
            }
            i++;
        }
        return result;
    }
}
