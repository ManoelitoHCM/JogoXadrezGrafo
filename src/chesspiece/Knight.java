package chesspiece;

import board.ChessNode;

public class Knight extends ChessPiece {

    public Knight(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        return new int[][]{
                {-2, -1}, {-2, 1}, // movimento em L para frente
                {-1, -2}, {-1, 2}, // movimento em L para os lados
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}    // movimento em L para trás
        };
    }
}
