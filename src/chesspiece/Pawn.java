package chesspiece;

import board.ChessNode;

public class Pawn extends ChessPiece {


    public Pawn(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {
        return new ChessNode[0][];
    }
}
