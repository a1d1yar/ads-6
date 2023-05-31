#  Assignment 6  |  Maratov Aldiyar


##  Vertex.java



__addAdjacentVertex()__
>__Description:__Adds an adjacent vertex with the specified weight. 

_Code:_
```java
public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
        }
```


__getData()__
>__Description:__Returns the data stored in the vertex. 

_Code:_
```java
 public V getData() {
        return data;
        }
```
__getAdjacentVertices()__
>__Description:__ Returns a map of adjacent vertices and their corresponding weights.

_Code:_
```java
public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
        }

```
## WeightedGraph.java
__addVertex()__
>__Description:__ Adds a vertex to the graph.

_Code:_
```java
  public void addVertex(Vertex<V> vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
        }
```
__addEdge()__
>__Description:__  Adds a weighted edge between two vertices in the graph.

_Code:_
```java
 public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
```



__removeEdge()__
>__Description:__  Removes an edge between two vertices in the graph.

_Code:_
```java
public void removeEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);

        source.getAdjacentVertices().remove(destination);
        destination.getAdjacentVertices().remove(source);
        }
```



__hasEdge()__
>__Description:__ Checks if an edge exists between two vertices in the graph.
> 
_Code:_
```java
public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);

        return source.getAdjacentVertices().containsKey(destination);
        }
```


__getNeighbors()__
>__Description:__ Returns a list of neighbors of a given vertex
> 
_Code:_
```java
  public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        validateVertex(vertex);
        return adjacencyList.get(vertex);
        }

```
__BFS()__
>__Description:__ Performs breadth-first search (BFS) starting from a given vertex.
_Code:_
```java
public void BFS(Vertex<V> start) {
        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        for (Vertex<V> vertex : adjacencyList.keySet()) {
        visited.put(vertex, false);
        }

        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.put(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
        Vertex<V> vertex = queue.poll();
        System.out.print(vertex.getData() + " ");

        List<Vertex<V>> neighbors = adjacencyList.get(vertex);
        for (Vertex<V> neighbor : neighbors) {
        if (!visited.get(neighbor)) {
        visited.put(neighbor, true);
        queue.add(neighbor);
        }
        }
        }
        }

```

__Dijkstra()__
>__Description:__ Performs Dijkstra's algorithm starting from a given vertex.
_Code:_
```java
  public Map<Vertex<V>, Double> Dijkstra(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        for (Vertex<V> vertex : adjacencyList.keySet()) {
        distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
        Vertex<V> vertex = priorityQueue.poll();
        double distance = distances.get(vertex);
        for (Map.Entry<Vertex<V>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
        Vertex<V> neighbor = entry.getKey();
        double weight = entry.getValue();
        double newDistance = distance + weight;
        if (newDistance < distances.get(neighbor)) {
        priorityQueue.remove(neighbor);
        distances.put(neighbor, newDistance);
        priorityQueue.add(neighbor);
        }
        }
        }
        return distances;
        }
```
__printGraph()__
>__Description:__  Prints the graph with its vertices and adjacent vertices.
> 
_Code:_
```java
public void printGraph() {
        for (Map.Entry<Vertex<V>, List<Vertex<V>>> entry : adjacencyList.entrySet()) {
        Vertex<V> vertex = entry.getKey();
        List<Vertex<V>> neighbors = entry.getValue();
        System.out.print("Vertex " + vertex.getData() + " is connected to: ");
        for (Vertex<V> neighbor : neighbors) {
        System.out.print(neighbor.getData() + " ");
        }
        System.out.println();
        }
        }
```

## Search

__Search__
>__Description:__  Performs a search starting from a given vertex.

_Code:_
```java
public interface Search<V> {
    void search(Vertex<V> start);
}

```
## BreadthFirstSearch.java
__Search()__
>__Description:__ Performs a breadth-first search starting from the given vertex.

_Code:_
```java
  @Override
public void search(Vertex<V> start) {
        graph.BFS(start);
        }
```
__search()__
>__Description:__  Performs Dijkstra's algorithm starting from the given vertex and prints the distances to all other vertices.

_Code:_
```java
  @Override
public void search(Vertex<V> start) {
        Map<Vertex<V>, Double> distances = graph.Dijkstra(start);

        for (Map.Entry<Vertex<V>, Double> entry : distances.entrySet()) {
        Vertex<V> vertex = entry.getKey();
        double distance = entry.getValue();
        System.out.println("Vertex " + vertex.getData() + ": " + distance);
        }
        }
```
