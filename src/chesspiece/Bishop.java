package chesspiece;

import board.ChessNode;

public class Bishop extends ChessPiece {

    public Bishop(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {
        return new ChessNode[0][];
    }
}
