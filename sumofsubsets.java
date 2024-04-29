import java.util.Scanner;

public class sumofsubsets {
    static int[] w;

    static void generateSubsets(int[] subset, int k, int n, int m) {
        if (k == n) {
            printSubset(subset, m);
        } else {
            subset[k] = 0;
            generateSubsets(subset, k + 1, n, m);
            subset[k] = 1;
            generateSubsets(subset, k + 1, n, m);
        }
    }

    static void printSubset(int[] subset, int m) {
        int sum = 0;
        for (int i = 0; i < subset.length; i++) {
            if (subset[i] == 1) {
                sum += w[i];
            }
        }
        if (sum == m) {
            for (int i = 0; i < subset.length; i++) {
                if (subset[i] == 1) {
                    System.out.print(w[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for array w
        System.out.println("Enter the size of the array w:");
        int size = scanner.nextInt();
        w = new int[size];
        System.out.println("Enter the elements of the array w:");
        for (int i = 0; i < size; i++) {
            w[i] = scanner.nextInt();
        }

        // User input for target sum m
        System.out.println("Enter the target sum m:");
        int m = scanner.nextInt();

        // Close scanner
        scanner.close();

        int[] subset = new int[size];
        generateSubsets(subset, 0, size, m);
    }
}
