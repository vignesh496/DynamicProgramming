import java.util.ArrayList;
import java.util.List;

class CoinChange  {
    public static void main(String[] args) {
        int[] coins = {1,2,5,10};
        coinChange(coins, 10);
    }
    static void coinChange(int[] coins, int amt)    {
        int[][] dp = new int[coins.length + 1][amt + 1];
        for (int i = 0; i < amt + 1; i++)   {
            dp[0][i] = amt + 1;
        }
        for (int i = 0; i < coins.length; i++)  {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++)   {
            for (int j = 1; j <= amt; j++)   {
                if (j - coins[i - 1] < 0)   {
                    dp[i][j] = dp[i - 1][j];
                }
                else if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        System.out.print("Coins\\Amount\t");
        for (int i = 1; i < amt+1; i++) {
            System.out.print(i+"\t");
        }
        System.out.println("\n");
        for (int i = 1; i < coins.length + 1; i++)  {
            System.out.print(coins[i - 1] + "\t->\t");
            for (int j = 1; j < amt + 1; j++)   {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nMinimum coins required : " + dp[coins.length][amt]);
        System.out.println("Coins used : " + getCoinsUsed(dp, coins, amt));
    }
    static List<Integer> getCoinsUsed(int[][] dp, int[] coins, int amt) {
        List<Integer> result = new ArrayList<>();
        int i = coins.length;
        int j = amt;
        while (j > 0 && i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                result.add(coins[i - 1]);
                j -= coins[i - 1];
            }
        }
        return result;
    }
}
