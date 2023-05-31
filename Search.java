/**
 * Represents a search algorithm in a graph.
 *
 * @param <V> the type of data stored in the vertices
 */
public interface Search<V> {
    /**
     * Performs a search starting from a given vertex.
     *
     * @param start the starting vertex for the search
     */
    void search(Vertex<V> start);
}
