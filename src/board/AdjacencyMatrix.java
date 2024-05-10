package board;

import chesspiece.ChessPiece;

import java.util.Optional;

public class AdjacencyMatrix {

    private final int size;
    private Optional<ChessPiece>[][] grid;
    private final boolean[][] adjacencyMatrix;

    private boolean[] visitedNodes;

    public AdjacencyMatrix(int size) {
        this.size = size;
        grid = new Optional[size][size];
        adjacencyMatrix = new boolean[size][size];

        for (int line = 0; line < size; line++) {
            for (int col = 0; col < size; col++) {
                grid[line][col] = Optional.empty();
                adjacencyMatrix[line][col] = false;
            }
        }
    }

    public int size() {
        return size;
    }

    public void insertVertex(ChessNode node) {
        int row = node.getRow();
        int col = node.getCol();
        grid[row][col] = Optional.empty();
    }

    public void insertPiece(ChessNode node, ChessPiece piece) {
        int row = node.getRow();
        int col = node.getCol();
        grid[row][col] = Optional.of(piece);
    }

    public Optional<ChessPiece> getPiece(ChessNode node) {
        int row = node.getRow();
        int col = node.getCol();
        return grid[row][col];
    }

    public void insertEdge(ChessNode sourceNode, ChessNode destinationNode) {
        if (sourceNode == destinationNode) {
            throw new IllegalArgumentException("Jogada inválida: o nó de origem e destino são iguais.");
        }
        int sourceRow = sourceNode.getRow();
        int sourceCol = sourceNode.getCol();
        int destinationRow = destinationNode.getRow();
        int destinationCol = destinationNode.getCol();

        adjacencyMatrix[sourceRow][sourceCol] = true;
        adjacencyMatrix[destinationRow][destinationCol] = true;
    }

    public boolean hasEdge(ChessNode sourceNode, ChessNode destinationNode) {
        int sourceRow = sourceNode.getRow();
        int sourceCol = sourceNode.getCol();
        int destinationRow = destinationNode.getRow();
        int destinationCol = destinationNode.getCol();

        return adjacencyMatrix[sourceRow][sourceCol] && adjacencyMatrix[destinationRow][destinationCol];
    }

    public void showMatrix() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col].isPresent() ? " X " : " - ");
            }
            System.out.println();
        }
    }
}
