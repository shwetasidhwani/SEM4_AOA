import java.util.*;

public class minmax {
    static void findMinMax(int a[], int i, int j, int minMax[]) {
        if (i == j) {
            minMax[0] = minMax[1] = a[i];
            return;
        }
        if (j == i + 1) {
            if (a[i] > a[j]) {
                minMax[0] = a[j];
                minMax[1] = a[i];
            } else {
                minMax[0] = a[i];
                minMax[1] = a[j];
            }
            return;
        }
        int mid = (i + j) / 2;
        int leftMinMax[] = new int[2];
        int rightMinMax[] = new int[2];
        findMinMax(a, i, mid, leftMinMax);
        findMinMax(a, mid + 1, j, rightMinMax);

        minMax[0] = leftMinMax[0] < rightMinMax[0] ? leftMinMax[0] : rightMinMax[0];
        minMax[1] = leftMinMax[1] > rightMinMax[1] ? leftMinMax[1] : rightMinMax[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to sort: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int minMax[] = new int[2];
        findMinMax(arr, 0, n - 1, minMax);
        System.out.println("Minimum element: " + minMax[0]);
        System.out.println("Maximum element: " + minMax[1]);
        sc.close();
    }
}
