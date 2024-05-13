package chesspiece;

import board.ChessNode;

public class Bishop extends ChessPiece {

    public Bishop(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        return new int[][]{
            {1, 1},     // diagonal superior direita
            {1, -1},    // diagonal superior esquerda
            {-1, 1},    // diagonal inferior direita
            {-1, -1}    // diagonal inferior esquerda
        };
    }

}
