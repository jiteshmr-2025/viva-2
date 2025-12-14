package viva2;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Mode (C/D): ");
        char mode = Character.toUpperCase(sc.nextLine().charAt(0));

        System.out.print("Text: ");
        String text = sc.nextLine();

        if (mode == 'C') {
            String output = compress(text);
            if (output.equals("Invalid encoding.")) {
                System.out.println(output);
            } else {
                System.out.println("Result: " + output);
            }
        } 
        else if (mode == 'D') {
            String output = decompress(text);
            if (output.equals("Invalid encoding.")) {
                System.out.println(output);
            } else {
                System.out.println("Result: " + output);
            }
        }

        sc.close();
    }
    public static String compress(String s) {
        //check whether is empty string
        if (s.length() == 0) return "";

        for(int i=0;i<s.length();i++){ 
            if(Character.isDigit(s.charAt(i))) 
                return "Invalid encoding.";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            //calculate count for same character byb comparing with previous character
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }

        // append last run
        result.append(count).append(s.charAt(s.length() - 1));
        return result.toString();
    }

    public static String decompress(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {

            // must start with a digit
            if (!Character.isDigit(s.charAt(i))) {
                return "Invalid encoding.";
            }

            int count = 0;

            // read full number (handles multi-digit numbers)
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }

            // number must be followed by a character
            if (i >= s.length()) {
                return "Invalid encoding.";
            }

            char ch = s.charAt(i);

            // expand
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }

            i++; // move to next segment
        }

        return result.toString();
    }
}
