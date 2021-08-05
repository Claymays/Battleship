package battleship;

import java.util.Arrays;
public class Main {
    static boolean hasBoats = true;
    static char[][] board = new char[10][10];

    public static void setTable() {
        for (char[] row : board) {
            Arrays.fill(row, '~');
        }
        while (hasBoats) {

            // print the board

            char letter = 'A';
            System.out.println(" 1 2 3 4 5 6 7 8 9 10");
            for (char[] chars : board) {
                System.out.print(letter + " ");
                letter++;
                for (int j = 0; j < board.length; j++) {
                    System.out.print(chars[j] + " ");
                }
                System.out.println();
            }

            // Ask for coordinates for placing each ship
            System.out.println("Enter the coordinates of ");
        }
    }
    public static void main(String[] args) {
        setTable();
    }
}
