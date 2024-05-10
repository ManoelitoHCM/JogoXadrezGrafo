package chesspiece;

import board.ChessNode;

public class Knight extends ChessPiece {

    public Knight(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {
        return new ChessNode[0][];
    }
}
