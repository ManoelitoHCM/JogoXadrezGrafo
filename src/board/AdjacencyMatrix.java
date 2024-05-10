package board;

import java.util.HashMap;
import java.util.Map;

import static board.ChessGraph.getGraphInstance;

public class AdjacencyMatrix {

    private boolean[][] adjacencyMatrix;
    private static AdjacencyMatrix matrixInstance;
    private final Map<ChessNode, Integer> nodeIndices;
    private final int size;

    private AdjacencyMatrix(int size, Map<ChessNode, Integer> nodeIndices) {
        this.size = size;
        this.adjacencyMatrix = new boolean[size][size];
        this.nodeIndices = new HashMap<>(size * size);

        int index = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // inicializando matriz
                adjacencyMatrix[row][col] = false;

                // recuperando nós criados no tabuleiro para mapeamento
                nodeIndices.put(getGraphInstance().getNode(row, col), index++);
            }
        }
    }

    public static void initializeiMatrix(int size, Map<ChessNode, Integer> nodeIndices) {
        if (matrixInstance == null) {
            matrixInstance = new AdjacencyMatrix(size, nodeIndices);
        }
    }

    public static AdjacencyMatrix getMatrixInstance() {
        if (matrixInstance == null) {
            throw new IllegalStateException("A matriz de adjacências ainda não foi inicializada. Chame o método initialize() primeiro.");
        }
        return matrixInstance;
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
