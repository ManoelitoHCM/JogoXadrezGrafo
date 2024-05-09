package board;

import chesspiece.*;

import java.util.Optional;

public class Board {

    private static Board boardInstance;
    private final int size;
    private final AdjacencyMatrix adjacencyMatrix;

    private Board() {
        this.size = 8;
        this.adjacencyMatrix = new AdjacencyMatrix(size * size);
        initializeAdjacencyMatrix();
    }

    public static Board getInstance() {
        if (boardInstance == null) {
            boardInstance = new Board();
        }
        return boardInstance;
    }

    public void placePiece(Position position, ChessPiece piece) {
        adjacencyMatrix.insertPiece(position, piece);
    }

    public Optional<ChessPiece> getPiece(Position position) {
        return adjacencyMatrix.getPiece(position);
    }

    private void initializeAdjacencyMatrix() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Position position = new Position(row, col);
                adjacencyMatrix.insertVertex(position);
            }
        }
    }

    private void initializeBoard() {
        // Define as posições iniciais para cada tipo de peça
        Position[] initialPositions = {
                new Position(0, 0), new Position(0, 7), // Rooks (Torres)
                new Position(0, 1), new Position(0, 6), // Knights (Cavalos)
                new Position(0, 2), new Position(0, 5), // Bishops (Bispos)
                new Position(0, 3),                              // Queen (Rainha)
                new Position(0, 4),                              // King (Rei)
                new Position(1, 0), new Position(1, 1), // Pawns (Peões)
                new Position(1, 2), new Position(1, 3),
                new Position(1, 4), new Position(1, 5),
                new Position(1, 6), new Position(1, 7)
        };

        // Coloca as peças nas posições iniciais
        for (Position position : initialPositions) {
            ChessPiece piece = createPiece(position);
            placePiece(position, piece);
        }
    }

    private ChessPiece createPiece(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        // Determina o tipo de peça com base na posição
        if (row == 0 && (col == 0 || col == 7)) {
            return new Rook(Color.WHITE, position);
        } else if (row == 0 && (col == 1 || col == 6)) {
            return new Knight(Color.WHITE, position);
        } else if (row == 0 && (col == 2 || col == 5)) {
            return new Bishop(Color.WHITE, position);
        } else if (row == 0 && col == 3) {
            return new Queen(Color.WHITE, position);
        } else if (row == 0 && col == 4) {
            return new King(Color.WHITE, position);
        } else if (row == 1) {
            return new Pawn(Color.WHITE, position);
        } else if (row == 7 && (col == 0 || col == 7)) {
            return new Rook(Color.BLACK, position);
        } else if (row == 7 && (col == 1 || col == 6)) {
            return new Knight(Color.BLACK, position);
        } else if (row == 7 && (col == 2 || col == 5)) {
            return new Bishop(Color.BLACK, position);
        } else if (row == 7 && col == 3) {
            return new Queen(Color.BLACK, position);
        } else if (row == 7 && col == 4) {
            return new King(Color.BLACK, position);
        } else if (row == 6) {
            return new Pawn(Color.BLACK, position);
        } else {
            return null; // Caso não haja uma peça na posição
        }
    }
    
    public boolean isValidPosition(Position newPosition) {
        int row = newPosition.getRow();
        int col = newPosition.getCol();

        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
