package chesspiece;

import board.Board;

import java.util.List;

public interface IChessPiece {
    Color getColor();

    void setColor(Color color);

    Position getPosition();

    void setPosition(Position position);

    List<Position> getPossibleMoves(Board board);

    boolean isValidMove(Position position, Position newPosition, Board board);

    void move(Position position, Position newPosition);

}
