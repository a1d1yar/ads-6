import java.util.Map;

/**
 * Implementation of the Dijkstra's algorithm for finding the shortest paths in a graph.
 *
 * @param <V> the type of data stored in the vertices
 */
public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    /**
     * Creates a new instance of DijkstraSearch with the specified graph.
     *
     * @param graph the weighted graph to perform the search on
     */
    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    /**
     * Performs Dijkstra's algorithm starting from the given vertex and prints the distances to all other vertices.
     *
     * @param start the starting vertex for the search
     */
    @Override
    public void search(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = graph.Dijkstra(start);

        for (Map.Entry<Vertex<V>, Double> entry : distances.entrySet()) {
            Vertex<V> vertex = entry.getKey();
            double distance = entry.getValue();
            System.out.println("Vertex " + vertex.getData() + ": " + distance);
        }
    }
}