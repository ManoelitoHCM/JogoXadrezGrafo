package chesspiece;

import board.ChessNode;

import java.util.List;

public class Bishop extends ChessPiece {

    public Bishop(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public List<ChessNode> getPossibleMoves() {
        return List.of();
    }


}
