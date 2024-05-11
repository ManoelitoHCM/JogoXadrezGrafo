package chesspiece;

import board.ChessNode;

import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {

    public Knight(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public List<ChessNode> getPossibleMoves(ChessNode[][] board) {

        List<ChessNode> possibleMoves = new ArrayList<>();
        ChessNode currentPosition = getCurrentNode();

        int[][] moveOffsets = {
                {-2, -1}, {-2, 1}, // movimento em L para frente
                {-1, -2}, {-1, 2}, // movimento em L para os lados
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}    // movimento em L para trás
        };

        for (int[] offset : moveOffsets) {

            ChessNode newNode = new ChessNode(currentPosition.getRow() + offset[0], currentPosition.getCol() + offset[1]);

            if (isValidMove(newNode)) {
                possibleMoves.add(newNode);
            }
        }
        return possibleMoves;
    }
}
