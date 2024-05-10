package search;

import board.ChessNode;
import board.ChessGraph;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
/*

    public static Queue<ChessNode> findPossibleMoves(ChessNode startNode, ChessGraph board) {
        Queue<ChessNode> possibleMoves = new LinkedList<>();
        // Implemente o algoritmo BFS aqui
        return possibleMoves;
    }

    @Override
    public int search(String value, int sourceNode, Graph graph) {
        AdjacencyMatrix adjacencyMatrix = (AdjacencyMatrix) graph;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedNodes = new boolean[adjacencyMatrix.size()];

        if (adjacencyMatrix.getLabel(sourceNode).equals(value)) {
            return sourceNode;
        }

        visitedNodes[sourceNode] = true;
        queue.add(sourceNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println(currentNode + " - value: " + adjacencyMatrix.getLabel(currentNode));

            for (int i = 0; i < adjacencyMatrix.size(); i++) {
                if (adjacencyMatrix.hasEdge(currentNode, i) && !visitedNodes[i]) {
                    if (adjacencyMatrix.getLabel(i).equals(value)) {
                        return i;
                    }
                    visitedNodes[i] = true;
                    queue.add(i);
                }
            }
        }
        return -1;
    }*/
}
