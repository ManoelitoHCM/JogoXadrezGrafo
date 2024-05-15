package chesspiece;

import board.ChessNode;

public class Bishop extends ChessPiece {

    public Bishop(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        int size = 7 * 4;
        int[][] offsets = new int[size][2];
        int index = 0;

        for (int i = 7; i >= -7; i--) {
            if (i != 0) {
                offsets[index][0] = i;
                offsets[index][1] = i;
                index++;
            }
        }

        for (int i = -7; i <= 7; i++) {
            if (i != 0) {
                offsets[index][0] = i;
                offsets[index][1] = -i;
                index++;
            }
        }

        return offsets;
    }
}
