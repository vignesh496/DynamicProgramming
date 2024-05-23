import java.util.*;

class MatrixChain {
    public static void main(String[] args) {
        int[] p = {4, 10, 3, 12, 20, 7};
        matrixChain(p);
    }
    static void matrixChain(int[] p)    {
        int n = p.length - 1;
        int[][] M = new int[n][n];
        int[][] s = new int[n][n]; 

        for (int i = 0; i < n; i++) {
            M[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                M[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = M[i][k] + M[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < M[i][j]) {
                        M[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum number of multiplications is " + M[0][n-1]);

        System.out.println("M matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    System.out.print(M[i][j] + "\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }

        System.out.println("s matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    System.out.print(s[i][j] + "\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }
}
