package chesspiece;

import board.ChessNode;

import java.util.List;

public class Rook extends ChessPiece {

    public Rook(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    protected int[][] listPossibleMoves() {
        return null;
    }

}
