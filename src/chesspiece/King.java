package chesspiece;

import board.ChessNode;

public class King extends ChessPiece {

    public King(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {
        return new ChessNode[0][];
    }
}
