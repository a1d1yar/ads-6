public class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    public BreadthFirstSearch (WeightedGraph<V> graph) {
        this.graph = graph;
    }
    @Override
    public void search (Vertex<V> start) {
        graph.BFS (start);
    }
}