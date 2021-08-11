package battleship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your code here
        SetShips set = new SetShips();
        BattleShip battleShip = new BattleShip();
        int counter = 0;

        set.placeShips(battleShip);
        System.out.println("The game starts!");
        Board board = battleShip.board;
        board.printStatus();
        System.out.println("Take a shot!");
        Scanner in = new Scanner(System.in);
        while (battleShip.getStatus().equals(GameStatus.SHOOT)) {
            String target = in.next();
            int row = target.charAt(0) - 'A';
            int col = Integer.parseInt(target.substring(1)) - 1;
            if (row < 0 || row > 9 || col > 9 || col < 0) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }
            if (board.getCell(row, col).equals(CellStatus.FOG)) {
                board.setCell(CellStatus.MISS, row, col);
                System.out.println("You missed!");
            } else if (board.getCell(target).equals(CellStatus.SHIP)) {
                board.setCell(CellStatus.HIT, row, col);
                System.out.println("You hit a ship!");
                counter++;
            }
            if (counter == 17) {
                battleShip.setStatus(GameStatus.END);
            }
        }
    }
}
