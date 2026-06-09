import java.util.Scanner;

public class LargestAndSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int fmax = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            if (curr > fmax) {
                smax = fmax;
                fmax = curr;
            }
            else if (curr > smax) {
                smax = curr;
            }
        }

        System.out.println("First Maximum = " + fmax);
        System.out.println("Second Maximum = " + smax);
    }
}
