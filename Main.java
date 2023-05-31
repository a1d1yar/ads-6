public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedGraph<>();

        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);

        graph.addEdge(vertex1, vertex2, 2.0);
        graph.addEdge(vertex1, vertex3, 3.0);
        graph.addEdge(vertex2, vertex4, 1.5);
        graph.addEdge(vertex3, vertex4, 2.5);
        graph.addEdge(vertex3, vertex5, 1.0);
        graph.addEdge(vertex4, vertex5, 3.0);

        graph.printGraph();

        Search<Integer> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("BFS: ");
        bfs.search(vertex1);
    }
}
