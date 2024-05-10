package board;

import chesspiece.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChessGraph implements Graph{
    private final int size;
    private final Map<String, ChessNode> nodes;
    private static ChessGraph boardInstance;

    private ChessGraph() {
        this.size = 8;
        this.nodes = new HashMap<>();
        initializeNodes();
        fillNodes();
    }

    public static ChessGraph getInstance() {
        if (boardInstance == null) {
            boardInstance = new ChessGraph();
        }
        return boardInstance;
    }

    public void initializeNodes() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                ChessNode node = new ChessNode(row, col);
                addNode(node);
            }
        }
    }

    public void fillNodes() {
        // define as posições iniciais para cada tipo de peça
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                ChessNode node = new ChessNode(row, col);
                addNode(node);
            }
        }
        ChessNode[] initialNodes = {
                // peças brancas
                new ChessNode(0, 0), new ChessNode(0, 7), // Rooks (Torres)
                new ChessNode(0, 1), new ChessNode(0, 6), // Knights (Cavalos)
                new ChessNode(0, 2), new ChessNode(0, 5), // Bishops (Bispos)
                new ChessNode(0, 3),                               // Queen (Rainha)
                new ChessNode(0, 4),                               // King (Rei)
                new ChessNode(1, 0), new ChessNode(1, 1), // Pawns (Peões)
                new ChessNode(1, 2), new ChessNode(1, 3),
                new ChessNode(1, 4), new ChessNode(1, 5),
                new ChessNode(1, 6), new ChessNode(1, 7),
                // peças pretas
                new ChessNode(7, 0), new ChessNode(7, 7), // Rooks (Torres)
                new ChessNode(7, 1), new ChessNode(7, 6), // Knights (Cavalos)
                new ChessNode(7, 2), new ChessNode(7, 5), // Bishops (Bispos)
                new ChessNode(7, 3),                               // Queen (Rainha)
                new ChessNode(7, 4),                               // King (Rei)
                new ChessNode(6, 0), new ChessNode(6, 1), // Pawns (Peões)
                new ChessNode(6, 2), new ChessNode(6, 3),
                new ChessNode(6, 4), new ChessNode(6, 5),
                new ChessNode(6, 6), new ChessNode(6, 7),
        };

        for (ChessNode node : initialNodes) {
            createPiece(node);
        }
    }

    @Override
    public ChessPiece createPiece(ChessNode node) {
        int row = node.getRow();
        int col = node.getCol();

        // Determina o tipo de peça com base na posição
        if (row == 0 && (col == 0 || col == 7)) {
            return new Rook(Color.WHITE, node);
        } else if (row == 0 && (col == 1 || col == 6)) {
            return new Knight(Color.WHITE, node);
        } else if (row == 0 && (col == 2 || col == 5)) {
            return new Bishop(Color.WHITE, node);
        } else if (row == 0 && col == 3) {
            return new Queen(Color.WHITE, node);
        } else if (row == 0 && col == 4) {
            return new King(Color.WHITE, node);
        } else if (row == 1) {
            return new Pawn(Color.WHITE, node);
        } else if (row == 7 && (col == 0 || col == 7)) {
            return new Rook(Color.BLACK, node);
        } else if (row == 7 && (col == 1 || col == 6)) {
            return new Knight(Color.BLACK, node);
        } else if (row == 7 && (col == 2 || col == 5)) {
            return new Bishop(Color.BLACK, node);
        } else if (row == 7 && col == 3) {
            return new Queen(Color.BLACK, node);
        } else if (row == 7 && col == 4) {
            return new King(Color.BLACK, node);
        } else if (row == 6) {
            return new Pawn(Color.BLACK, node);
        } else {
            return null; // Caso não haja uma peça na posição
        }
    }

    @Override
    public void insertPiece(ChessNode node, ChessPiece piece) {
        if (isValidPosition(node)) {
            node.setPiece(piece);
        } else {
            System.out.println("Posição inválida!");
        }
    }

    @Override
    public Optional<ChessPiece> getPiece(ChessNode node) {
        return Optional.empty();
    }

    @Override
    public boolean isValidPosition(ChessNode node) {
        int row = node.getRow();
        int col = node.getCol();
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    @Override
    public void addNode(ChessNode node) {
        String key = generateKey(node.getRow(), node.getCol());
        nodes.put(key, node);
    }

    public ChessNode getNode(int row, int col) {
        String key = generateKey(row, col);
        return nodes.getOrDefault(key, null);
    }

    @Override
    public void insertEdge(ChessNode sourceNode, ChessNode destinationNode) {
    }

    @Override
    public boolean hasEdge(ChessNode sourceNode, ChessNode destinationNode) {
        return false;
    }

    @Override
    public void showMatrix() {

    }

    public String generateKey(int row, int col) {
        return row + "_" + col;
    }

}
