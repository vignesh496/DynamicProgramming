import java.util.*;

class BinomialCoefficient {
    public static void main(String[] args) {
        binomial(7, 4);
    }
    public static void binomial(int n, int k)   {
        int[][] arr = new int[n+1][k+1];

        for (int i = 0; i <= n; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i <= k; i++)    {
            arr[i][i] = 1;
        }
        for (int i = 1; i <= n; i++)    {
            for (int j = 1; j <= Math.min(i, k); j++)   {
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        for (int i = 0; i <= n; i++)    {
            for(int j = 0; j <= Math.min(i, k); j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
