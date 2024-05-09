package chesspiece;

public abstract class ChessPiece {

    private Color color;

    public ChessPiece(Color color, Type type) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isValidMove(Position from, Position to);
}
