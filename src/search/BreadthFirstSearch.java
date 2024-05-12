package search;

import board.ChessNode;
import board.ChessGraph;
import chesspiece.ChessPiece;

import java.util.*;

import static board.ChessGraph.getGraphInstance;

public class BreadthFirstSearch {

    public static List<ChessNode> findPossibleMoves(ChessNode startNode) {
        ChessGraph board = getGraphInstance();

        List<ChessNode> possibleMoves = new ArrayList<>();
        Set<ChessNode> visitedNodes = new HashSet<>();
        Queue<ChessNode> queue = new LinkedList<>();

        if (startNode.hasPiece()) {
            Optional<ChessPiece> piece = startNode.getPiece();
            int[][] offsets = piece.get().getOffsets();

            visitedNodes.add(startNode);
            queue.add(startNode);

            while (!queue.isEmpty()) {
                ChessNode currentNode = queue.poll();

                for (ChessNode neighbor : currentNode.getNeighbors()) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);

                        if (neighbor.isValidMove(piece)) {
                            for (int[] offset : offsets) {
                                int newRow = currentNode.getRow() + offset[0];
                                int newCol = currentNode.getCol() + offset[1];

                                if (neighbor.getRow() == newRow && neighbor.getCol() == newCol) {
                                    possibleMoves.add(neighbor);
                                    queue.add(neighbor);
                                }
                            }
                        }
                    }
                }
            }
            return possibleMoves;
        } else {
            throw new NullPointerException("Não há peça nessa posição.");
        }
    }
}
