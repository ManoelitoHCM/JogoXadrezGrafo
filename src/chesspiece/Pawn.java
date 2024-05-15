package chesspiece;

import board.ChessNode;
import exceptions.InvalidMoveException;

import java.util.Scanner;

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
                if (isOpponentInDiagonal()) {
                    return new int[][]{{1, 1}, {1, 0}, {1, -1}};
                } else {
                    return new int[][]{{1, 0}};
                }
            }
        } else { // Color.BLACK
            if (!hasMoved) {
                return new int[][]{{-2, 0}, {-1, 0}};
            } else {
                if (isOpponentInDiagonal()) {
                    return new int[][]{{-1, 1}, {-1, 0}, {-1, -1}};
                } else {
                    return new int[][]{{-1, 0}};
                }
            }
        }
    }

    private boolean isOpponentInDiagonal() {
        for (ChessNode neighbor : this.getCurrentNode().getNeighbors()) {
            if (neighbor.hasPiece() && neighbor.getPiece().isOpponentPiece(this.getCurrentNode())) {
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
    public void move(ChessNode newNode) throws InvalidMoveException {
        super.move(newNode);
        hasMoved = true;
        checkAndPromotePawn(newNode);
    }

    private void checkAndPromotePawn(ChessNode newNode) {
        int lastRow = (this.getColor() == Color.WHITE ? 7 : 0);
        
        if (newNode.getRow() == lastRow) {
            String promotionChoice = getPromotionChoiceFromPlayer();
            ChessPiece newPiece = promotePawn(promotionChoice);
            this.getCurrentNode().removePiece();
            newNode.setPiece(newPiece);
            newPiece.setCurrentNode(newNode);
        }
    }

    private String getPromotionChoiceFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a peça para promoção (queen, rook, bishop, knight): ");
        return scanner.nextLine();
    }

    private ChessPiece promotePawn(String promotionChoice) {
        switch (promotionChoice.toLowerCase()) {
            case "queen":
                return new Queen(this.getColor(), this.getCurrentNode());
            case "rook":
                return new Rook(this.getColor(), this.getCurrentNode());
            case "bishop":
                return new Bishop(this.getColor(), this.getCurrentNode());
            case "knight":
                return new Knight(this.getColor(), this.getCurrentNode());
            default:
                throw new IllegalArgumentException("Tipo de peça inválido.");
        }
    }
}
