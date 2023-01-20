package day9_tictactoegame;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    // initializes the 3x3 tic tac toe board
    static char[][] board = new char[3][3];
    // initialize the scanner class
    static Scanner sc = new Scanner(System.in);
    // create player variable with 'X'
    static char player = 'X';

    public static void main(String[] args) {

        // creates the 'pockets' on the tic tac toe board for user inputs
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        play();

    } // end of main

    public static void play() {
        boolean playing = true;
        while (playing) {
            System.out.println("");
            System.out.println("Current board layout:");
            printBoard();
            System.out.println("");
            System.out.println("Player " + player
                    + ", enter the row and column of your move (e.g. '1 2' for the top row middle column): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            System.out.println("");
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = player;
                if (checkWin()) {
                    System.out.println("Player " + player + " wins!");
                    playing = false;
                } else if (checkTie()) {
                    System.out.println("It's a tie!");
                    playing = false;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public static boolean checkWin() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---+---+---");
            }
        }
    }

}
