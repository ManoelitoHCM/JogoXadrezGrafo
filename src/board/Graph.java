package board;

import java.util.Collection;

public interface Graph {

    void initializeNodes();

    void fillNodes();

    void display();

    void addNode(ChessNode node);

    ChessNode getNode(int row, int col);

    Collection<ChessNode> getNodes();

    String generateKey(int row, int col);

    boolean isValidPosition(ChessNode newNode);

    int getSize();
}
