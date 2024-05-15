package search;

import board.ChessGraph;
import board.ChessNode;
import chesspiece.ChessPiece;
import chesspiece.Color;
import chesspiece.King;

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
                        queue.add(neighbor);
                    }
                }

                if (currentNode.isValidMove(startNode)) {
                    for (int[] offset : offsets) {
                        int newRow = piece.getCurrentNode().getRow() + offset[0];
                        int newCol = piece.getCurrentNode().getCol() + offset[1];

                        if (ChessGraph.getGraphInstance().isInBounds(newRow, newCol)) {
                            if (currentNode.getRow() == newRow && currentNode.getCol() == newCol) {
                                possibleMoves.add(currentNode);
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

    public static ChessNode findOppositeKing(ChessNode startNode) {

        ChessNode kingNode = null;
        Set<ChessNode> visitedNodes = new HashSet<>();
        Queue<ChessNode> queue = new LinkedList<>();

        if (startNode.hasPiece()) {

            visitedNodes.add(startNode);
            queue.add(startNode);

            while (!queue.isEmpty()) {
                ChessNode currentNode = queue.poll();

                for (ChessNode neighbor : currentNode.getNeighbors()) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);
                        queue.add(neighbor);
                    }
                }

                if (currentNode.hasPiece() &&
                        currentNode.getPiece().isOpponentPiece(startNode) &&
                        currentNode.getPiece() instanceof King) {

                    kingNode = currentNode;
                    break;
                }
            }
            if (kingNode != null) {
                return kingNode;
            } else {
                throw new NoSuchElementException("Rei do adversário não encontrado no tabuleiro.");
            }
        } else {
            throw new NullPointerException("Não há peça na posição inicial.");
        }
    }
}
