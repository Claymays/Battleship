package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void placeShip(Ship ship, String x, String y) {
    //haha
    }

    public static boolean isValidCoordinate(String x, String y) {
      return true;
    }

    static boolean hasBoats = true;
    static char[][] board = new char[10][10];

    public static void setTable() {
        Scanner in = new Scanner(System.in);
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
            for (Ship ship : Ship.values()) {
                System.out.println("Enter the coordinates of " + ship.getPrintName());
                String[] coordinates = in.nextLine().split(" ");
                if (isValidCoordinate(coordinates[0], coordinates[1])) {
                    placeShip(ship, coordinates[0], coordinates[1]);
                }
            }
        }
    }
    public static void main(String[] args) {
        setTable();
    }
}
