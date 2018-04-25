<<<<<<< HEAD
import java.util.HashMap;

public class DiceRollSum {

    // Runtime: O(N)
    // Space: O(N)
    public static int diceRollSum(int N) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return diceRollSumDP(N, memo);
    }

    private static int diceRollSumDP(int n, HashMap<Integer, Integer> memo) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (memo.containsKey(n))
            return memo.get(n);
        int r = diceRollSumDP(n - 1, memo) + diceRollSumDP(n - 2, memo) + diceRollSumDP(n - 3, memo) +
                diceRollSumDP(n - 4, memo) + diceRollSumDP(n - 5, memo) + diceRollSumDP(n - 6, memo);
        memo.put(n, r);
        return r;
=======
public class DiceRollSum {

    // Runtime: TODO
    // Space: TODO
    public static int diceRollSum(int N) {
        // TODO
        return 0;
>>>>>>> 84f81784b5484b283d38d8900f42a8955698ad97
    }

}
