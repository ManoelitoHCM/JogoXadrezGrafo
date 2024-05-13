package chesspiece;

import board.ChessNode;
import search.BreadthFirstSearch;
import search.DepthFirstSearch;

import java.util.List;

public abstract class ChessPiece implements IChessPiece {

    private Color color;
    private ChessNode currentNode;

    public ChessPiece(Color color, ChessNode currentNode) {
        this.color = color;
        this.currentNode = currentNode;
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
    public ChessNode getCurrentNode() {
        return currentNode;
    }

    public boolean isOpponentPiece(ChessNode newNode) {
        return newNode.getPiece().getColor() != this.getColor();
    }

    public abstract int[][] getOffsets();

    @Override
    public List<ChessNode> filterValidMoves(ChessNode currentNode) {
        return BreadthFirstSearch.findPossibleMoves(currentNode);
    }

    private boolean isValidMove(ChessNode newNode) {
        return filterValidMoves(currentNode).contains(newNode);
    }

    @Override
    public void move(ChessNode newNode) {
        if (isValidMove(newNode)) {
            this.currentNode.removePiece();
            this.currentNode = newNode;
            newNode.setPiece(this);
        } else {
            System.out.println("Jogada inválida.");
        }
    }
}
