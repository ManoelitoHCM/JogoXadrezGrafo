package game;

import board.ChessNode;
import chesspiece.ChessPiece;
import exceptions.InvalidMoveException;
import exceptions.NoPieceOnNodeException;
import exceptions.NotPlayersTurnException;

public class Move {
    private ChessNode fromNode;
    private ChessNode toNode;
    private ChessPiece piece;

    public Move(ChessNode fromNode, ChessNode toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.piece = fromNode.getPiece();
    }

    public boolean isValid() {
        return fromNode != null && toNode != null && fromNode.hasPiece() && piece.isValidMove(toNode);
    }

    public void execute() throws NoPieceOnNodeException, NotPlayersTurnException, InvalidMoveException {
        if (fromNode == null || !fromNode.hasPiece()) {
            throw new NoPieceOnNodeException("Não há peça na posição (" + fromNode.getRow() + ", " + fromNode.getCol() + ").");
        }

        if (piece == null) {
            throw new InvalidMoveException("Nenhuma peça para mover.");
        }

        if (!isValid()) {
            throw new InvalidMoveException("Movimento inválido de " + piece.getClass().getSimpleName() + " para a posição (" + toNode.getRow() + ", " + toNode.getCol() + ").");
        }

        piece.move(toNode);
    }

    public ChessPiece getPiece() {
        return piece;
    }
}
