import java.util.HashMap;
import java.util.Map;

/**
 * Represents a vertex in a graph.
 *
 * @param <V> the type of data stored in the vertex
 */
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    /**
     * Creates a new vertex with the specified data.
     *
     * @param data the data to be stored in the vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Adds an adjacent vertex with the specified weight.
     *
     * @param destination the adjacent vertex to be added
     * @param weight      the weight of the edge connecting the vertices
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Returns the data stored in the vertex.
     *
     * @return the data stored in the vertex
     */
    public V getData() {
        return data;
    }

    /**
     * Returns a map of adjacent vertices and their corresponding weights.
     *
     * @return a map of adjacent vertices and their weights
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
