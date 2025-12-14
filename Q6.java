import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] aStr;
        String[] bStr;

        do {
            System.out.print("Array A: ");
            aStr = sc.nextLine().split(",");
        } while (!checkValid(aStr));

        do {
            System.out.print("Array B: ");
            bStr = sc.nextLine().split(",");
        } while (!checkValid(bStr));

        int[] a = new int[aStr.length];
        int[] b = new int[bStr.length];

        for (int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(aStr[i].trim());

        for (int i = 0; i < b.length; i++)
            b[i] = Integer.parseInt(bStr[i].trim());

        System.out.println("Mirror pattern: " + isMirror(a, b));

        sc.close();
    }

    // Checks if array length is between 1 and 50
    static boolean checkValid(String[] arr) {
        if (arr.length < 1 || arr.length > 50) {
            System.out.println("Invalid input. Array length must be between 1 and 50.");
            return false;
        }
        return true;
    }

    static boolean isMirror(int[] a, int[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[b.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
