import java.util.Scanner;

public class insertionsort {
    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int index = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > index) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = index;
        }
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
        System.out.println("Array before sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        insertionSort(arr);
        System.out.println("\nArray after sorting: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
