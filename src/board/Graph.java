package board;

import chesspiece.*;

import java.util.Optional;

public interface Graph {

    void initializeNodes();

    void fillNodes();

    ChessPiece createPiece(ChessNode node);

    void insertPiece(ChessNode node, ChessPiece piece);

    Optional<ChessPiece> getPiece(ChessNode node);

    void addNode(ChessNode node);

    ChessNode getNode(int row, int col);

    void insertEdge(ChessNode sourceNode, ChessNode destinationNode);

    boolean hasEdge(ChessNode sourceNode, ChessNode destinationNode);

    void showMatrix();

    String generateKey(int row, int col);

    boolean isValidPosition(ChessNode newNode);
}

