package battleship;

import java.util.Scanner;

public class SetShips {
    BattleShip battleShip = new BattleShip();
    Scanner s = new Scanner(System.in);

    boolean statusIn = true;
    String[] command = null;

     {
        switch(battleShip.getStatus()) {
            case STARTED:
                battleShip.showBoard();
                battleShip.setStatus(GameStatus.AIRCRAFT);
                break;
            case AIRCRAFT:
                if (statusIn) {
                    battleShip.showMessage(GameStatus.AIRCRAFT);
                    statusIn = false;
                }
                command = s.nextLine().trim().split(" ");
                if(battleShip.setBoard(GameStatus.AIRCRAFT, command[0], command[1])) {
                    statusIn = true;
                    battleShip.setStatus(GameStatus.BATTLESHIP);
                    battleShip.showBoard();
                }
                break;
            case BATTLESHIP:
                if (statusIn) {
                    battleShip.showMessage(GameStatus.BATTLESHIP);
                    statusIn = false;
                }
                command = s.nextLine().trim().split(" ");
                if(battleShip.setBoard(GameStatus.BATTLESHIP, command[0], command[1])) {
                    statusIn = true;
                    battleShip.setStatus(GameStatus.SUBMARINE);
                    battleShip.showBoard();
                }
                break;
            case SUBMARINE:
                if (statusIn) {
                    battleShip.showMessage(GameStatus.SUBMARINE);
                    statusIn = false;
                }
                command = s.nextLine().trim().split(" ");
                if(battleShip.setBoard(GameStatus.SUBMARINE, command[0], command[1])) {
                    statusIn = true;
                    battleShip.setStatus(GameStatus.CRUISER);
                    battleShip.showBoard();
                }
                break;
            case CRUISER:
                if (statusIn) {
                    battleShip.showMessage(GameStatus.CRUISER);
                    statusIn = false;
                }
                command = s.nextLine().trim().split(" ");
                if(battleShip.setBoard(GameStatus.CRUISER, command[0], command[1])) {
                    statusIn = true;
                    battleShip.setStatus(GameStatus.DESTROYER);
                    battleShip.showBoard();
                }
                break;
            case DESTROYER:
                if (statusIn) {
                    battleShip.showMessage(GameStatus.DESTROYER);
                    statusIn = false;
                }
                command = s.nextLine().trim().split(" ");
                if(battleShip.setBoard(GameStatus.DESTROYER, command[0], command[1])) {
                    statusIn = true;
                    battleShip.setStatus(GameStatus.END);
                    battleShip.showBoard();
                }
                break;
                default:
        }
    }
}
