package chesspiece;

import board.ChessNode;

public class Queen extends ChessPiece {

    public Queen(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        return new int[][]{
            {0, 1},     // movimento para frente
            {0, -1},    // movimento para trás
            {1, 0},     // movimento para direita
            {-1, 0},    // movimento para esquerda
            {1, 1},     // diagonal superior direita
            {1, -1},    // diagonal superior esquerda
            {-1, 1},    // diagonal inferior direita
            {-1, -1}    // diagonal inferior esquerda
        };
    }
}
