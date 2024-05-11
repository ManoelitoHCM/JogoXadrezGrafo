package chesspiece;

import board.ChessNode;

import java.util.List;

public interface IChessPiece {
    Color getColor();

    void setColor(Color color);

    ChessNode getCurrentNode();

    List<ChessNode> getPossibleMoves();

    boolean isValidMove(ChessNode newNode);

    void move(ChessNode newNode);

}
