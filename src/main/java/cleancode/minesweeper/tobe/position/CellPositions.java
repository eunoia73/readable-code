package cleancode.minesweeper.tobe.position;


import cleancode.minesweeper.tobe.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellPositions {
    private final List<CellPosition> positions;

    public CellPositions(List<CellPosition> positions) {
        this.positions = positions;
    }

    public static CellPositions of(List<CellPosition> positions) {
        return new CellPositions(positions);
    }

    public static CellPositions from(Cell[][] board) {
        List<CellPosition> cellPositions = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                CellPosition cellPosition = CellPosition.of(row, col);
                cellPositions.add(cellPosition);
            }
        }
        return of(cellPositions);
    }

    public List<CellPosition> getPositions() {
        return new ArrayList<>(positions);  //외부에서 참조할 수 없도록 새롭게 만들어서 반환
    }
}
