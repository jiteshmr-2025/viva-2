package q4;

import java.util.Scanner;

/**
 *
 * @author ekitstrap
 */
public class Q4 {

    /**
     * 1. Read the three board rows from the user. 2. Construct a 2D array of
     * characters. 3. Call checkWinner() to determine the result. 4. Display the
     * output as: a. "Winner: X" or "Winner: O" if a player has won, b. "No
     * winner" if the game has no winning line.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize Scanner object
        Scanner input = new Scanner(System.in);

        // Initialize board
        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            System.out.printf("Row %d: ", i + 1);
            String temp = input.next();

            // Make sure temp is 3
            if (temp.length() != 3) {
                System.out.println("Invalid number of inputs.");
                return;
            }

            String validChars = "XO.";
            for (char r : temp.toCharArray()) {
                // If "XO." does not contain the character 'r'
                if (validChars.indexOf(r) == -1) {
                    System.out.println("Your board is invalid.");
                    return;
                }
            }
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        int countX = countMoves(board, 'X');
        int countO = countMoves(board, 'O');
        // Checking if number of moves is valid
        if (countX == countO || (countX - countO) == 1) {
            // Call checkwinner()
            char winner = checkWinner(board);
            switch (winner) {
                case 'X' ->
                    System.out.println("Winner: 'X' ");
                case 'O' ->
                    System.out.println("Winner: 'O' ");
                case 'I' ->
                    System.out.println("Invalid board, 2 winners at the same time.");
                default ->
                    System.out.println("No winner.");
            }
        } else {
            System.out.println("Number of moves is not valid.");
        }
    }

    /**
     * Checks how many moves have been played.
     *
     * @param board The main playing board
     * @param player The current character to be checked
     * @return the number of moves made by a player
     */
    public static int countMoves(char[][] board, char player) {
        int count = 0;
        for (char[] board1 : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (board1[j] == player) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *
     * @param board The main playing board
     * @return The winner of the game or . if no winner
     */
    public static char checkWinner(char[][] board) {
        // Check if the same symbol appears in any complete row, column, or one of the two diagonals.
        // Define size for board first
        int size = board[0].length;

        // Now, create booleans to check if both x and O wins.
        boolean xWin = false;
        boolean oWin = false;

        // Check row and column
        int countRowX = 0;
        int countRowY = 0;
        int countColX = 0;
        int countColY = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Check rows
                if (board[i][j] == 'X') {
                    countRowX++;
                    if (countRowX == size) {
                        xWin = true;
                    }
                }
                if (board[i][j] == 'O') {
                    countRowY++;
                    if (countRowY == size) {
                        oWin = true;
                    }
                }

                // Check columns
                if (board[j][i] == 'X') {
                    countColX++;
                    if (countColX == size) {
                        xWin = true;
                    }
                }

                if (board[j][i] == 'O') {
                    countColY++;
                    if (countColY == size) {
                        oWin = true;
                    }
                }
            }
            countRowX = 0;
            countRowY = 0;
            countColX = 0;
            countColY = 0;
        }

        // Diagonal checking
        /*
        and also reverse of these
        0, 0 -> i = j
        1, 1 -> i = j
        2, 2 -> i = j
         */
        // Everytime method starts we can reset these values
        int countDiagForwardX = 0;
        int countDiagForwardY = 0;
        int countDiagBackX = 0;
        int countDiagBackY = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                countDiagForwardX++;
                if (countDiagForwardX == size) {
                    xWin = true;
                }
            }
            if (board[i][i] == 'O') {
                countDiagForwardY++;
                if (countDiagForwardY == size) {
                    oWin = true;
                }
            }
            if (board[i][board.length - 1 - i] == 'X') {
                countDiagBackX++;
                if (countDiagBackX == size) {
                    xWin = true;
                }
            }
            if (board[i][board.length - 1 - i] == 'O') {
                countDiagBackY++;
                if (countDiagBackY == size) {
                    oWin = true;
                }
            }
        }

        // --- 3. Final Validation ---
        if (xWin && oWin) {
            return 'I'; // Invalid: Both players won
        }
        if (xWin) {
            return 'X';
        }
        if (oWin) {
            return 'O';
        }

        return '.';
    }

}
