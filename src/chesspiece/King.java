package chesspiece;

import board.ChessNode;

import java.util.List;

public class King extends ChessPiece {

    public King(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    protected int[][] listPossibleMoves() {
        return null;
    }

}
