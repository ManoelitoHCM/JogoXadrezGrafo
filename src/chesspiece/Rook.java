package chesspiece;

import board.ChessNode;

public class Rook extends ChessPiece {

    public Rook(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        return new int[][]{
            {0, 1},     // movimento para frente
            {0, -1},    // movimento para trás
            {1, 0},     // movimento para direita
            {-1, 0}     // movimento para esquerda
        };
    }
}
