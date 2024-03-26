import java.util.*;

class Knapsack {
    static ArrayList<Integer> list = null;
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    public static void findCost(int capacity, int weight[], int cost[], int n) {
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) 
                    dp[i][j] = 0;
                else if (weight[i - 1] <= j) 
                    dp[i][j] = max(cost[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                else 
                    dp[i][j] = dp[i - 1][j];
            }
        }
        list = new ArrayList<>();
        int i = n, j = capacity;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                list.add(i);
                j -= weight[i - 1];
            }
            i--;
        }
        for (int x = 0; x <= n; x++) {
            if (x == 0)
                System.out.print("Item 0        -> \t");
            else if (x < n)
                System.out.print("Item "+ x + " ("+weight[x-1] + ", " + cost[x-1]+") ->\t");
            else if (x == n)
                System.out.print("Item "+ x + " ("+weight[x-1] + ", " + cost[x-1]+") ->\t");
            for (int y = 0; y <= capacity; y++) {
                System.out.print(dp[x][y] + "\t");
            }
            System.out.println();
        }
        System.out.println("Maximum Cost: " + dp[n][capacity]);
        System.out.println("Selected items: " + list.reversed());
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter no. of items : ");
        int n = input.nextInt();
        int[] weight = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Item - " + (i + 1)+ " (weight, cost)");
            weight[i] = input.nextInt();
            cost[i] = input.nextInt();
        }
        System.out.print("Enter capacity of Knapsack : ");
        int capacity = input.nextInt();
        findCost(capacity, weight, cost, n);
    }
}
