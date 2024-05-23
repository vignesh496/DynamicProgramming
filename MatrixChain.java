import java.util.*;

class MatrixChain {
    public static void main(String[] args) {
        int[] p = {5, 4, 3 , 2, 1, 6};
        matrixChain(p);
    }
    public static void matrixChain(int[] p) {
        int n = p.length;
        int[][] M = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                M[i][j] = Integer.MAX_VALUE;
            }
            M[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n-l+1; i++) {
                int j = l + i - 1;
                for (int k = i; k < j; k++) {
                    int a = M[i][k] + M[k+1][j] + (p[i-1] * p[k] * p[j]);
                    if (a <= M[i][j])    {
                        M[i][j] = a;
                        s[i][j] = k;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Minimum no. of multiplications : " + M[1][n-1]);

    }
}
