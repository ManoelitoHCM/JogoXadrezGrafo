package chesspiece;

import board.Board;

import java.util.List;

public class King extends ChessPiece {

    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    public List<Position> getPossibleMoves(Board board) {
        return List.of();
    }

    @Override
    public boolean isValidMove(Position from, Position to, Board board) {
        return false;
    }

    @Override
    public void move(Position from, Position to) {

    }
}
