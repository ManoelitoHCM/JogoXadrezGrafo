package chesspiece;

import board.ChessNode;

import java.util.List;

public class Pawn extends ChessPiece {


    public Pawn(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public List<ChessNode> getPossibleMoves() {
        return List.of();
    }

}
