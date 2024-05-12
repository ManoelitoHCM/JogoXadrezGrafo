package search;

import board.ChessNode;
import chesspiece.ChessPiece;

import java.util.*;

public class BreadthFirstSearch {

    public static List<ChessNode> findPossibleMoves(ChessNode startNode) {

        List<ChessNode> possibleMoves = new ArrayList<>();
        Set<ChessNode> visitedNodes = new HashSet<>();
        Queue<ChessNode> queue = new LinkedList<>();

        if (startNode.hasPiece()) {
            ChessPiece piece = startNode.getPiece();
            int[][] offsets = piece.getOffsets();

            visitedNodes.add(startNode);
            queue.add(startNode);

            while (!queue.isEmpty()) {
                ChessNode currentNode = queue.poll();

                for (ChessNode neighbor : currentNode.getNeighbors()) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);

                        if (currentNode.isValidMove()) {
                            for (int[] offset : offsets) {
                                int newRow = startNode.getRow() + offset[0];
                                int newCol = startNode.getCol() + offset[1];

                                if (currentNode.getRow() == newRow && currentNode.getCol() == newCol) {
                                    possibleMoves.add(currentNode);
                                }
                            }
                        }
                        queue.add(neighbor);
                    }
                }
            }
            return possibleMoves;
        } else {
            throw new NullPointerException("Não há peça nessa posição.");
        }
    }
}
