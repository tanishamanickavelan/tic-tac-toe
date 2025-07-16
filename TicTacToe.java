import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] and column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Validate input
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            // Check for win
            if (hasWon(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check for draw
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Print the current board
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Check for a win
    static boolean hasWon(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (
                (board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)
            ) {
                return true;
            }
        }

        if (
            (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)
        ) {
            return true;
        }

        return false;
    }

    // Check for draw
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
