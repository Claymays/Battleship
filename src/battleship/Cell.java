package battleship;

public class Cell {
    public int row;
    public int col;
    CellStatus status;

    public Cell(int row, int col, CellStatus status) {
        this.row = row;
        this.col = col;
        this.status = status;
    }

    boolean isSmallerThan(Cell cell) {
        if (this.row == cell.row) {
            return this.col < cell.col;
        } else {
            return this.row < cell.row;
        }
    }
}
