package chesspiece;

import board.ChessNode;

public class Pawn extends ChessPiece {

    private boolean hasMoved;

    public Pawn(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        if (getColor() == Color.WHITE) {
            if (!hasMoved) {
                return new int[][]{{-2, 0}, {-1, 0}, {-1, 1}, {-1, -1}};
            } else {
                return new int[][]{{-1, 0}, {-1, 1}, {-1, -1}};
            }
        } else {
            if (!hasMoved) {
                return new int[][]{{2, 0}, {1, 0}, {1, 1}, {1, -1}};
            } else {
                return new int[][]{{1, 0}, {1, 1}, {1, -1}};
            }
        }
    }
}
