package board;

public interface Graph {

    void initializeNodes();

    void fillNodes();

    void display();

    void addNode(ChessNode node);

    ChessNode getNode(int row, int col);

}
