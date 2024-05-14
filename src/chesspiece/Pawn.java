package chesspiece;

import board.ChessNode;

public class Pawn extends ChessPiece {

    private boolean hasMoved = false;

    public Pawn(Color color, ChessNode currentNode) {
        super(color, currentNode);
    }

    @Override
    public int[][] getOffsets() {
        if (getColor() == Color.WHITE) {
            if (!hasMoved) {
                return new int[][]{{2, 0}, {1, 0}};
            } else {
                if (!isOpponentInDiagonal()) {
                    return new int[][]{{1, 0}};
                } else {
                    return new int[][]{{1, 1}, {1, -1}};
                }
            }
        } else { // Color.BLACK
            if (!hasMoved) {
                return new int[][]{{-2, 0}, {-1, 0}};
            } else {
                if (!isOpponentInDiagonal()) {
                    return new int[][]{{-1, 0}};
                } else {
                    return new int[][]{{-1, 1}, {-1, -1}};
                }
            }
        }
    }


    private boolean isOpponentInDiagonal() {
        for (ChessNode neighbor : this.getCurrentNode().getNeighbors()) {
            if (neighbor.hasPiece() && neighbor.getPiece().isOpponentPiece(this.getCurrentNode())) ;
            {
                int rowDifference = neighbor.getRow() - this.getCurrentNode().getRow();
                int colDifference = neighbor.getCol() - this.getCurrentNode().getCol();
                // Se a peça estiver na diagonal
                if (Math.abs(rowDifference) == 1 && Math.abs(colDifference) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void move(ChessNode newNode) {
        super.move(newNode);
        hasMoved = true;
    }
}
