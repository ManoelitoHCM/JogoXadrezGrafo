package chesspiece;

import board.ChessNode;

public class Queen extends ChessPiece {

    public Queen(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {
        return new ChessNode[0][];
    }
}
