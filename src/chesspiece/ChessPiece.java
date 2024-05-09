package chesspiece;

import board.Board;

import java.util.List;

public abstract class ChessPiece implements IChessPiece{

    private Color color;
    private Position position;

    public ChessPiece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Position getPosition(){
        return position;
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }

    @Override
    public abstract List<Position> getPossibleMoves(Board board);

    @Override
    public boolean isValidMove(Position position, Position newPosition, Board board){
        return board.isValidPosition(newPosition);
    }

    @Override
    public void move(Position position, Position newPosition){}
}
