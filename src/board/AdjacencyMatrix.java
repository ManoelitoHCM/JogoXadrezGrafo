package board;

public class AdjacencyMatrix implements Graph {

    private final int size;
    private String[] labels;
    private final int[][] adjacencyMatrix;

    private boolean[] visitedNodes;

    public AdjacencyMatrix(int size) {
        this.size = size;
        labels = new String[size];
        adjacencyMatrix = new int[size][size];

        for (int line = 0; line < size; line++) {
            for (int column = 0; column < size; column++) {
                adjacencyMatrix[line][column] = 0;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    public void insertVertex(int node, String label) {
        labels[node] = label;
    }

    public String getLabel(int node) {
        return labels[node];
    }

    public void insertEdge(int sourceNode, int destinationNode) {
        if (sourceNode == destinationNode) {
            throw new IllegalArgumentException("Jogada inválida: o nó de origem e destino são iguais.");
        }
        adjacencyMatrix[sourceNode][destinationNode] = 1;
    }

    public boolean hasEdge(int sourceNode, int destinationNode) {
        return adjacencyMatrix[sourceNode][destinationNode] != 0;
    }

    public void showMatrix() {
        for (int line = 0; line < size; line++) {
            for (int column = 0; column < size; column++) {
                System.out.print(adjacencyMatrix[line][column] + " ");
            }
            System.out.println();
        }
    }
}
