package chesspiece;

import board.ChessGraph;
import board.ChessNode;

public class Pawn extends ChessPiece {


    public Pawn(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public ChessNode[][] getPossibleMoves(ChessNode[][] board) {

        int row = getCurrentNode().getRow();
        int col = getCurrentNode().getCol();

        // para alinhar a movimentação de acordo com o lado do tabuleiro
        int direction = (getColor() == Color.WHITE) ? -1 : 1;

        // um movimento para frente e um para cada diagonal
        ChessNode[][] possibleMoves = new ChessNode[3][1];
        int moveCount = 0;

        ChessNode nextNode = new ChessNode(row + direction, col);

        // verifica a frente
        if (ChessGraph.getGraphInstance().isValidPosition(nextNode) && !ChessGraph) {

        }

        return new ChessNode[0][];
    }
}
