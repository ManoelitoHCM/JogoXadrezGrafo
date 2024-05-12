package chesspiece;

import board.ChessNode;

import java.util.List;

public interface IChessPiece {

    Color getColor();

    void setColor(Color color);

    ChessNode getCurrentNode();

    List<ChessNode> filterValidMoves(ChessNode currentNode);

    void move(ChessNode newNode);

}
