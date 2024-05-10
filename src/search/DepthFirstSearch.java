package search;

public class DepthFirstSearch {
/*
    @Override
    public int search(String value, int sourceNode, Graph graph) {
        AdjacencyMatrix adjacencyMatrix = (AdjacencyMatrix) graph;
        Stack<Integer> stack = new Stack<>();
        boolean[] visitedNodes = new boolean[adjacencyMatrix.size()];
        stack.push(sourceNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            visitedNodes[currentNode] = true;
            System.out.println(currentNode + " - value: " + adjacencyMatrix.getLabel(currentNode));

            if (adjacencyMatrix.getLabel(currentNode).equals(value)) {
                return currentNode;
            }

            for (int i = 0; i < adjacencyMatrix.size(); i++) {
                if (adjacencyMatrix.hasEdge(currentNode, i) && !visitedNodes[i]) {
                    stack.push(i);
                }
            }
        }
        return -1;
    }

 */
}
