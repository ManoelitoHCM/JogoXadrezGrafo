package board;

import chesspiece.ChessPiece;
import chesspiece.Position;

import java.util.Optional;

public interface Graph {
    void insertPiece(Position position, ChessPiece piece);
    Optional<ChessPiece> getPiece(Position position);
    void insertEdge(Position sourcePosition, Position destinationPosition);
    boolean hasEdge(Position sourcePosition, Position destinationPosition);
    void showMatrix();
    int size();
}
