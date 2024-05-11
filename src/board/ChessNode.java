package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import chesspiece.ChessPiece;
import chesspiece.Color;

public class ChessNode {
    private final int row;
    private final int col;
    private Optional<ChessPiece> piece;
    private List<ChessNode> neighbors;
    private final Color color;

    public ChessNode(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = Optional.empty();
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

    public Optional<ChessPiece> getPiece() {
        return piece;
    }

    public boolean hasPiece() {
        return this.getPiece().isPresent();
    }

    public void setPiece(ChessPiece piece) {
        this.piece = Optional.of(piece);
    }

    public void removePiece() {
        this.piece = Optional.empty();
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
        return "(row: " + row + ", col: " + col + ")";
    }
}
