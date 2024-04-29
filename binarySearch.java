import java.util.Scanner;

public class binarySearch {
    static void BinarySearch(int arr[], int first, int last, int val) {
        int m = (first + last) / 2;
        while (first <= last) {
            if (val > arr[m]) {
                first = m + 1;
            } else if (val < arr[m]) {
                last = m - 1;
            } else {
                System.out.println("Element found at index: " + m);
                break;
            }
            m = (first + last) / 2;
            if (first > last) {
                System.out.println("Element not found.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to be searched: ");
        int val = sc.nextInt();
        BinarySearch(arr, 0, n - 1, val);
        sc.close();
    }
}
