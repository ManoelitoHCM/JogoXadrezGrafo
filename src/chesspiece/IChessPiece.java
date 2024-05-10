package chesspiece;

import board.ChessGraph;
import board.ChessNode;

public interface IChessPiece {
    Color getColor();

    void setColor(Color color);

    ChessNode getCurrentNode();

    void setCurrentNode(ChessNode currentNode);

    ChessNode[][] getPossibleMoves(ChessNode[][] board);

    boolean isValidMove(ChessNode newNode, ChessGraph board);

    void move(ChessNode newNode);

}
