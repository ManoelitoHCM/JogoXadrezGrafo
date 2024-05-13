package board;

import chesspiece.*;

import java.util.HashMap;
import java.util.Map;

public class ChessGraph {

    private final int size;
    private final Map<String, ChessNode> nodes;
    private static ChessGraph boardInstance;

    private ChessGraph() {
        this.size = 8;
        this.nodes = new HashMap<>();
        initializeNodes();
        createEdges();
    }

    public static ChessGraph getGraphInstance() {
        if (boardInstance == null) {
            boardInstance = new ChessGraph();
        }
        return boardInstance;
    }

    private void initializeNodes() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                ChessNode node = new ChessNode(row, col);
                ChessPiece piece = null;

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
                addNode(node);
            }
        }
    }

    private void createEdges() {
        for (int row = 0; row < size; row ++) {
            for (int col = 0; col < size; col++) {
                ChessNode currentNode = getNode(row, col);

                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue;

                        int newRow = row + dr;
                        int newCol = col + dc;

                        if (newRow >= 0 && newCol >= 0 && newRow < size && newCol < size) {
                            ChessNode neighborNode = getNode(newRow, newCol);
                            currentNode.addNeighbor(neighborNode);
                        }
                    }
                }
            }
        }
    }

    public void display() {
        System.out.println("    1  2  3  4  5  6  7  8");
        System.out.println("  +-----------------------+");

        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " | ");
            for (int col = 0; col < size; col++) {
                ChessPiece piece = getNode(row, col).getPiece();
                String pieceSymbol = "-";

                if (piece != null) {
                    pieceSymbol = String.valueOf(piece.getClass().getSimpleName().charAt(0)).toUpperCase();
                }

                System.out.print(String.format("%3s", pieceSymbol));
            }
            System.out.println(" | " + (row + 1));
        }

        System.out.println(" +------------------------+");
        System.out.println("    1  2  3  4  5  6  7  8");
    }


    private void addNode(ChessNode node) {
        int row = node.getRow();
        int col = node.getCol();
        nodes.put(getIndex(row, col), node);
    }

    public ChessNode getNode(int row, int col) {
        return nodes.getOrDefault(getIndex(row, col), null);
    }

    private String getIndex(int row, int col) {
        return row + "_" + col;
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
