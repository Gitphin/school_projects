import java.util.*;


public class LabTwelveClass {
    public static void main(String[] args) {


        GraphInterface<Integer> simpleGraph = instantiateSampleGraph();

	System.out.println("############################");
        System.out.println("BFS Traversal: ");
        Queue<VertexInterface<Integer>> simpleGraphBFSResult = simpleGraph.getBreadthFirstTraversal(1);
        outputQueue(simpleGraphBFSResult);

        simpleGraphBFSResult = simpleGraph.getBreadthFirstTraversal(7);
        outputQueue(simpleGraphBFSResult);

        System.out.println("############################");
        System.out.println("DFS Traversal: ");

        Queue<VertexInterface<Integer>> simpleGraphDfsResult = simpleGraph.getDepthFirstTraversal(1);
        outputQueue(simpleGraphDfsResult);

        simpleGraphDfsResult = simpleGraph.getDepthFirstTraversal(7);
        outputQueue(simpleGraphDfsResult);

       	System.out.println("############################");
        System.out.println("Measuring Degrees: ");

        Map<Integer, Integer> simpleGraphMeasureDegreesMap = simpleGraph.measureDegrees();
        outputMap(simpleGraphMeasureDegreesMap);

     }


    public static void outputQueue(Queue<VertexInterface<Integer>> queue) {
        if (queue == null || queue.size() == 0) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue contains: ");
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }

    public static void outputMap(Map<Integer, Integer> map) {
        if (null != map) {
            for (Integer vertexLabel: map.keySet()) {
                if (map.get(vertexLabel) != 0)
                    System.out.println(String.format("The degree for the vertex labeled " + vertexLabel + " is " +
                        map.get(vertexLabel)));
            }
        }
    }


    public static GraphInterface<Integer> instantiateSampleGraph() {
        GraphInterface<Integer> simpleGraph = new SimpleGraph();
        for (int i = 0; i < 10; i++)
            simpleGraph.addVertex(i);
        simpleGraph.addEdge(1, 6, 1.0);
        simpleGraph.addEdge(6, 1, 1.0);
        simpleGraph.addEdge(1, 9, 2.0);
        simpleGraph.addEdge(9, 1, 2.0);
        simpleGraph.addEdge(9, 7, 3.0);
        simpleGraph.addEdge(7, 9, 3.0);
        simpleGraph.addEdge(9, 8, 4.0);
        simpleGraph.addEdge(8, 9, 4.0);
        simpleGraph.addEdge(6, 5, 5.0);
        simpleGraph.addEdge(5, 6, 5.0);
        simpleGraph.addEdge(6, 4, 6.0);
        simpleGraph.addEdge(4, 6, 6.0);
        simpleGraph.addEdge(6, 2, 7.0);
        simpleGraph.addEdge(2, 6, 7.0);
        simpleGraph.addEdge(6, 3);
        simpleGraph.addEdge(3, 6);
        return simpleGraph;
    }

}
