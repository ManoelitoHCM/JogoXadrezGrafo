package board;

public interface Graph {
    void insertVertex(int node, String label);
    void insertEdge(int firstNode, int lastNode);
    void showMatrix();
    int size();
}
