import java.util.Arrays;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        int l, r;
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++)
        {
            l = i + 1;
            r = arr.length - 1;
            while (l < r)
            {
                if (arr[i] + arr[l] + arr[r] == sum)
                {
                    count++;
                    l++;
                    r--;
                }
                else if (arr[i] + arr[l] + arr[r] < sum)
                    l++;

                else
                    r--;
            }
        }
        return count;
    }
}
