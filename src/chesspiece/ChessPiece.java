package chesspiece;

import board.ChessGraph;
import board.ChessNode;

public abstract class ChessPiece implements IChessPiece{

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

    @Override
    public void setCurrentNode(ChessNode currentNode){
        this.currentNode = currentNode;
    }

    @Override
    public abstract ChessNode[][] getPossibleMoves(ChessNode[][] board);

    @Override
    public boolean isValidMove(ChessNode newNode, ChessGraph board){
        return board.isValidPosition(newNode);
    }

    @Override
    public void move(ChessNode newNode){
        this.currentNode.removePiece();
        this.currentNode = newNode;
        newNode.setPiece(this);
    }
}
