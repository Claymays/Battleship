package battleship;

public class Cell {
    public int row;
    public int col;
    CellStatus status;
    GameStatus shipName;

    public Cell(int row, int col, CellStatus status, GameStatus ship) {
        this.row = row;
        this.col = col;
        this.status = status;
        this.shipName = ship;
    }

    boolean isSmallerThan(Cell cell) {
        if (this.row == cell.row) {
            return this.col < cell.col;
        } else {
            return this.row < cell.row;
        }
    }
}
