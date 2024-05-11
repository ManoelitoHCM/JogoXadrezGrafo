package chesspiece;

import board.ChessNode;

import java.util.List;

public class Queen extends ChessPiece {

    public Queen(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public List<ChessNode> getPossibleMoves() {
        return List.of();
    }
}
