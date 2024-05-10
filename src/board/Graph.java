package board;

import chesspiece.*;

import java.util.Optional;

public interface Graph {

    void initializeNodes();

    void fillNodes();

    ChessPiece createPiece(ChessNode node);

    void addNode(ChessNode node);

    ChessNode getNode(int row, int col);

    String generateKey(int row, int col);

    boolean isValidPosition(ChessNode newNode);
}
