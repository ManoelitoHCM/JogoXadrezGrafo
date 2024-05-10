package chesspiece;

import board.ChessNode;

public class Rook extends ChessPiece {

    public Rook(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {
        return new ChessNode[0][];
    }
}
