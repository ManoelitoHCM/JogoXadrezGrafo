package board;

import chesspiece.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChessGraph implements Graph {

    private final int size;
    private final Map<String, ChessNode> nodes;
    private static ChessGraph boardInstance;
    private ChessNode node;

    private ChessGraph() {
        this.size = 8;
        this.nodes = new HashMap<>();
        initializeNodes();
        fillNodes();
        createEdges();
    }

    public static ChessGraph getGraphInstance() {
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
        int[][] initialNodes = {
                // peças brancas
                {0, 0}, {0, 7}, // rooks (torres)
                {0, 1}, {0, 6}, // knights (cavalos)
                {0, 2}, {0, 5}, // bishops (bispos)
                {0, 3},         // queen (rainha)
                {0, 4},         // king (rei)
                {1, 0}, {1, 1}, // pawns (peões)
                {1, 2}, {1, 3},
                {1, 4}, {1, 5},
                {1, 6}, {1, 7},
                // peças pretas
                {7, 0}, {7, 7}, // rooks (torres)
                {7, 1}, {7, 6}, // knights (cavalos)
                {7, 2}, {7, 5}, // bishops (bispos)
                {7, 3},         // queen (rainha)
                {7, 4},         // king (rei)
                {6, 0}, {6, 1}, // pawns (peões)
                {6, 2}, {6, 3},
                {6, 4}, {6, 5},
                {6, 6}, {6, 7}
        };

        for (int[] nodePosition : initialNodes) {
            ChessNode node = getNode(nodePosition[0], nodePosition[1]);

            if (node != null && !node.hasPiece()) {
                createPiece(node);
            }
        }
    }

    private void createPiece(ChessNode node) {
        ChessPiece piece = null;
        int row = node.getRow();
        int col = node.getCol();

        // Determina o tipo de peça com base na posição
        if (row == 0 && (col == 0 || col == 7)) {
            piece = new Rook(Color.WHITE, node);
        } else if (row == 0 && (col == 1 || col == 6)) {
            piece = new Knight(Color.WHITE, node);
        } else if (row == 0 && (col == 2 || col == 5)) {
            piece = new Bishop(Color.WHITE, node);
        } else if (row == 0 && col == 3) {
            piece = new Queen(Color.WHITE, node);
        } else if (row == 0 && col == 4) {
            piece = new King(Color.WHITE, node);
        } else if (row == 1) {
            piece = new Pawn(Color.WHITE, node);
        } else if (row == 7 && (col == 0 || col == 7)) {
            piece = new Rook(Color.BLACK, node);
        } else if (row == 7 && (col == 1 || col == 6)) {
            piece = new Knight(Color.BLACK, node);
        } else if (row == 7 && (col == 2 || col == 5)) {
            piece = new Bishop(Color.BLACK, node);
        } else if (row == 7 && col == 3) {
            piece = new Queen(Color.BLACK, node);
        } else if (row == 7 && col == 4) {
            piece = new King(Color.BLACK, node);
        } else if (row == 6) {
            piece = new Pawn(Color.BLACK, node);
        }

        if (piece != null) {
            node.setPiece(piece);
        }
    }

    public void createEdges() {
        for (int row = 0; row < size; row ++) {
            for (int col = 0; col < size; col++) {
                ChessNode currentNode = getNode(row, col);

                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue;

                        int newRow = row + dr;
                        int newCol = col + dr;

                        if (newRow > 0 && newCol > 0 && newRow < size && newCol < size) {
                            ChessNode neighborNode = getNode(newRow, newCol);
                            currentNode.addNeighbor(neighborNode);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void display() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Optional<ChessPiece> optionalPiece = getNode(row, col).getPiece();

                String pieceSymbol = optionalPiece.map(piece -> piece.getClass().getSimpleName()).orElse("-");
                System.out.print(pieceSymbol + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void addNode(ChessNode node) {
        int row = node.getRow();
        int col = node.getCol();

        nodes.put(getIndex(row, col), node);
    }

    @Override
    public ChessNode getNode(int row, int col) {
        String index = getIndex(row, col);
        return nodes.getOrDefault(index, null);
    }

    private String getIndex(int row, int col) {
        return row + "_" + col;
    }

    public int getSize() {
        return size;
    }
}
