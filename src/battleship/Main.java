package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean player1 = true;
    static void switchPlayer() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
            player1 = !player1;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        // Write your code here
        SetShips set = new SetShips();
        Scanner in = new Scanner(System.in);
        BattleShip battleShip = new BattleShip();
        BattleShip fogBoard1 = new BattleShip();
        BattleShip battleShip2 = new BattleShip();
        BattleShip fogBoard2 = new BattleShip();

        int counter = 0;
        int carrier = 0;
        int cruiser = 0;
        int bShip = 0;
        int submarine = 0;
        int destroyer = 0;

        int counter2 = 0;
        int carrier2 = 0;
        int cruiser2 = 0;
        int bShip2 = 0;
        int submarine2 = 0;
        int destroyer2 = 0;

        set.placeShips(battleShip);
        switchPlayer();
        set.placeShips(battleShip2);
        switchPlayer();

        Board board = battleShip.board;
        Board board2 = battleShip2.board;

        while (battleShip.getStatus().equals(GameStatus.SHOOT)) {
            if (player1) {
                System.out.println("Player 1, it's your turn:");
                fogBoard2.showBoard();
                board.printStatus();
                String target = in.next();
                int row = target.charAt(0) - 'A';
                int col = Integer.parseInt(target.substring(1)) - 1;
                if (row < 0 || row > 9 || col > 9 || col < 0) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }
                if (board2.getCell(target).status.equals(CellStatus.FOG)) {
                    fogBoard2.board.setCell(CellStatus.MISS, row, col, GameStatus.STARTED);
                    fogBoard2.showBoard();
                    board2.setCell(CellStatus.MISS, row, col, GameStatus.STARTED);
                    System.out.println("You missed!");
                } else if (board2.getCell(target).status.equals(CellStatus.SHIP)) {
                    fogBoard2.board.setCell(CellStatus.HIT, row, col, board2.getCell(target).shipName);
                    fogBoard2.showBoard();
                    board2.setCell(CellStatus.HIT, row, col, board2.getCell(target).shipName);
                    counter++;
                    switch (board2.getCell(target).shipName) {
                        case CRUISER -> cruiser++;
                        case BATTLESHIP -> bShip++;
                        case AIRCRAFT -> carrier++;
                        case SUBMARINE -> submarine++;
                        case DESTROYER -> destroyer++;
                    }
                    if (carrier == 5) {
                        System.out.println("You sank a ship! Specify a new target:");
                        carrier = 0;
                    } else if (bShip == 4) {
                        System.out.println("You sank a ship! Specify a new target:");
                        bShip = 0;
                    } else if (submarine == 3) {
                        System.out.println("You sank a ship! Specify a new target:");
                        submarine = 0;
                    } else if (cruiser == 3) {
                        System.out.println("You sank a ship! Specify a new target:");
                        cruiser = 0;
                    } else if (destroyer == 2) {
                        System.out.println("You sank a ship! Specify a new target:");
                        destroyer = 0;
                    } else {
                        System.out.println("You hit a ship!");
                    }
                }
                switchPlayer();
            } else {
                System.out.println("Player 2, it's your turn:");
                String target = in.next();
                int row = target.charAt(0) - 'A';
                int col = Integer.parseInt(target.substring(1)) - 1;
                if (row < 0 || row > 9 || col > 9 || col < 0) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }
                if (board.getCell(target).status.equals(CellStatus.FOG)) {
                    fogBoard1.board.setCell(CellStatus.MISS, row, col, GameStatus.STARTED);
                    fogBoard1.showBoard();
                    board.setCell(CellStatus.MISS, row, col, GameStatus.STARTED);
                    System.out.println("You missed!");
                } else if (board.getCell(target).status.equals(CellStatus.SHIP)) {
                    fogBoard1.board.setCell(CellStatus.HIT, row, col, board.getCell(target).shipName);
                    fogBoard1.showBoard();
                    board.setCell(CellStatus.HIT, row, col, board.getCell(target).shipName);
                    counter2++;
                    switch (board.getCell(target).shipName) {
                        case CRUISER -> cruiser2++;
                        case BATTLESHIP -> bShip2++;
                        case AIRCRAFT -> carrier2++;
                        case SUBMARINE -> submarine2++;
                        case DESTROYER -> destroyer2++;
                    }
                    if (carrier2 == 5) {
                        System.out.println("You sank a ship! Specify a new target:");
                        carrier2 = 0;
                    } else if (bShip2 == 4) {
                        System.out.println("You sank a ship! Specify a new target:");
                        bShip2 = 0;
                    } else if (submarine2 == 3) {
                        System.out.println("You sank a ship! Specify a new target:");
                        submarine2 = 0;
                    } else if (cruiser2 == 3) {
                        System.out.println("You sank a ship! Specify a new target:");
                        cruiser2 = 0;
                    } else if (destroyer2 == 2) {
                        System.out.println("You sank a ship! Specify a new target:");
                        destroyer2 = 0;
                    } else {
                        System.out.println("You hit a ship!");
                    }
                }
                switchPlayer();
            }


            if (counter == 17) {
                System.out.println("You sank the last ship, player 1. You won. Congratulations!");
                battleShip.setStatus(GameStatus.END);
            } else if (counter2 == 17) {
                System.out.println("You sank the last ship, player 2. You won. Congratulations!");
                battleShip.setStatus(GameStatus.END);
                }

            }
        }
    }

