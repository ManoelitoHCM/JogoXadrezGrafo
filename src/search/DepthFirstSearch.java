package search;

import board.ChessNode;
import chesspiece.ChessPiece;
import chesspiece.King;

import java.util.*;

public class DepthFirstSearch {

    public static List<ChessNode> findPossibleMoves(ChessNode startNode) {

        List<ChessNode> possibleMoves = new ArrayList<>();
        Set<ChessNode> visitedNodes = new HashSet<>();
        Stack<ChessNode> stack = new Stack<>();

        if (startNode.hasPiece()) {
            ChessPiece piece = startNode.getPiece();
            int[][] offsets = piece.getOffsets();

            visitedNodes.add(startNode);
            stack.push(startNode);

            while (!stack.isEmpty()) {
                ChessNode currentNode = stack.pop();

                for (ChessNode neighbor : currentNode.getNeighbors()) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);
                        stack.push(neighbor);
                    }
                }

                if (currentNode.isValidMove(startNode)) {
                    for (int[] offset : offsets) {
                        int newRow = piece.getCurrentNode().getRow() + offset[0];
                        int newCol = piece.getCurrentNode().getCol() + offset[1];

                        if (currentNode.getRow() == newRow && currentNode.getCol() == newCol) {
                            possibleMoves.add(currentNode);
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
        Stack<ChessNode> stack = new Stack<>();

        if (startNode.hasPiece()) {

            visitedNodes.add(startNode);
            stack.push(startNode);

            while (!stack.isEmpty()) {
                ChessNode currentNode = stack.pop();

                for (ChessNode neighbor : currentNode.getNeighbors()) {
                    if (!visitedNodes.contains(neighbor)) {
                        visitedNodes.add(neighbor);
                        stack.push(neighbor);
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
