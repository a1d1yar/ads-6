/**
 * Implementation of the Breadth-First Search algorithm.
 *
 * @param <V> the type of data stored in the vertices
 */
public class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    /**
     * Creates a new instance of BreadthFirstSearch with the specified graph.
     *
     * @param graph the weighted graph to perform the search on
     */
    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    /**
     * Performs a breadth-first search starting from the given vertex.
     *
     * @param start the starting vertex for the search
     */
    @Override
    public void search(Vertex<V> start) {
        graph.BFS(start);
    }
}
