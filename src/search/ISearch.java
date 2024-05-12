package search;

import board.ChessNode;

import java.util.List;

public interface ISearch {

    List<ChessNode> findPossibleMoves(ChessNode startNode);
}
