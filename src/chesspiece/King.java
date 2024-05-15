package chesspiece;

import board.ChessNode;

public class King extends ChessPiece {

    public King(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        int size = 7 * 8 + 1;
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

        for (int i = 7; i >= -7; i--) {
            if (i != 0) {
                offsets[index][0] = i;
                offsets[index][1] = 0;
                index++;
            }
        }

        for (int i = 7; i >= -7; i--) {
            if (i != 0) {
                offsets[index][0] = 0;
                offsets[index][1] = i;
                index++;
            }
        }
        return offsets;
    }
}
