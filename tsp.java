import java.util.Scanner;

public class tsp {
    static int MAX = 1000000;
    static int[][] dist;
    static int n;

    static int[][] memo;

    static int TSP(int i, int mask) {
        if (mask == ((1 << i) | 1)) // Base case: If only ith bit and 1st bit is set in our mask
            return dist[0][i];
        if (memo[i][mask] != 0)
            return memo[i][mask];

        int res = MAX;

        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) != 0 && j != i && j != 0) {
                res = Math.min(res, TSP(j, mask & (~(1 << i))) + dist[j][i]);
            }
        }
        return memo[i][mask] = res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes:");
        n = scanner.nextInt();

        dist = new int[n][n];
        memo = new int[n][1 << (n + 1)];

        System.out.println("Enter the distance matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }

        int ans = MAX;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, TSP(i, (1 << (n)) - 1) + dist[i][0]);
        }

        System.out.println("The cost of the most efficient tour = " + ans);
    }
}
