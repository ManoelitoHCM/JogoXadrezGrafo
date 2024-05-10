package board;

import java.util.HashMap;
import java.util.Map;

public class AdjacencyMatrix {

    private final int size;
    private final boolean[][] adjacencyMatrix;
    private final Map<ChessNode, Integer> nodeIndices;

    public AdjacencyMatrix(Map<ChessNode, Integer> nodeIndex, ChessGraph board) {

        this.size = ChessGraph.getInstance().getSize();
        adjacencyMatrix = new boolean[size][size];
        nodeIndices = new HashMap<>(size * size);

        int index = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // inicializando matriz
                adjacencyMatrix[row][col] = false;

                // recuperando nós criados no tabuleiro para mapeamento
                nodeIndices.put(board.getNode(row, col), index++);
            }
        }
    }

    public int size() {
        return size;
    }

    public void insertEdge(ChessNode sourceNode, ChessNode destinationNode) {
        if (sourceNode == destinationNode) {
            throw new IllegalArgumentException("Jogada inválida: o nó de origem e destino são iguais.");
        }
        int sourceIndex = nodeIndices.get(sourceNode);
        int destinationIndex = nodeIndices.get(destinationNode);

        adjacencyMatrix[sourceIndex][destinationIndex] = true;
    }

    public boolean hasEdge(ChessNode sourceNode, ChessNode destinationNode) {
        int sourceIndex = nodeIndices.get(sourceNode);
        int destinationIndex = nodeIndices.get(destinationNode);

        return adjacencyMatrix[sourceIndex][destinationIndex];
    }

    public void showMatrix() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(adjacencyMatrix[row][col]);
            }
            System.out.println();
        }
    }
}
