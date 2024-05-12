package board;

import java.util.ArrayList;
import java.util.List;

import chesspiece.ChessPiece;
import chesspiece.Color;

public class ChessNode {
    private final int row;
    private final int col;
    private ChessPiece piece;
    private List<ChessNode> neighbors;
    private final Color color;

    public ChessNode(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null;
        this.neighbors = new ArrayList<>();
        // regra para gerar as cores do tabuleiro
        this.color = (row + col) % 2 == 0 ? Color.WHITE : Color.BLACK;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }

    public boolean isValidMove() {
        return !this.hasPiece() || getPiece().isOpponentPiece(this);
    }

    public Color getColor() {
        return color;
    }

    public List<ChessNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(ChessNode neighborNode) {
        neighbors.add(neighborNode);
    }

    @Override
    public String toString() {
        return "ChessNode{" +
                "row=" + row +
                ", col=" + col +
                ", piece=" + piece +
                ", color=" + color +
                '}';
    }
}
