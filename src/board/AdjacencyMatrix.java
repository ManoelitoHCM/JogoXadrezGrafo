package board;

import chesspiece.ChessPiece;
import chesspiece.Position;

import java.util.Optional;

public class AdjacencyMatrix implements Graph {

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

    @Override
    public int size() {
        return size;
    }

    public void insertVertex(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        grid[row][col] = Optional.empty();
    }

    public void insertPiece(Position position, ChessPiece piece) {
        int row = position.getRow();
        int col = position.getCol();
        grid[row][col] = Optional.of(piece);
    }

    public Optional<ChessPiece> getPiece(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return grid[row][col];
    }

    public void insertEdge(Position sourcePosition, Position destinationPosition) {
        if (sourcePosition == destinationPosition) {
            throw new IllegalArgumentException("Jogada inválida: o nó de origem e destino são iguais.");
        }
        int sourceRow = sourcePosition.getRow();
        int sourceCol = sourcePosition.getCol();
        int destinationRow = destinationPosition.getRow();
        int destinationCol = destinationPosition.getCol();

        adjacencyMatrix[sourceRow][sourceCol] = true;
        adjacencyMatrix[destinationRow][destinationCol] = true;
    }

    public boolean hasEdge(Position sourcePosition, Position destinationPosition) {
        int sourceRow = sourcePosition.getRow();
        int sourceCol = sourcePosition.getCol();
        int destinationRow = destinationPosition.getRow();
        int destinationCol = destinationPosition.getCol();

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
