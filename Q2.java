import java.util.Scanner;

public class Q2 {

    public static boolean isBalanced(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            // If closing parenthesis appears before a matching opening one
            if (count < 0) {
                return false;
            }
        }

        // Balanced only if count ends at 0
        return count == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String str = sc.nextLine();

        if (isBalanced(str)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }
}
