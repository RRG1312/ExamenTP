package Ejercicio3;

import java.util.*;

public class Graph<V> {

    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    public boolean addVertex(V v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        Set<V> neighbors = adjacencyList.get(v1);
        if (!neighbors.contains(v2)) {
            neighbors.add(v2);
            return true;
        }
        return false;
    }

    public Set<V> obtainAdjacents(V v) throws Exception {
        if (!containsVertex(v)) {
            throw new Exception("Vertex not found in graph");
        }
        return adjacencyList.get(v);
    }

    public boolean containsVertex(V v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : adjacencyList.keySet()) {
            sb.append(v.toString());
            sb.append(": ");
            sb.append(adjacencyList.get(v).toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<V> onePath(V v1, V v2) throws Exception {
        Map<V, V> trace = new HashMap<>();
        Stack<V> open = new Stack<>();
        open.push(v1);
        trace.put(v1, null);
        boolean found = false;
        while (!open.isEmpty() && !found) {
            V v = open.pop();
            found = v.equals(v2);
            for (V s : obtainAdjacents(v)) {
                if (!trace.containsKey(s)) {
                    open.push(s);
                    trace.put(s, v);
                }
            }
        }
        if (found) {
            List<V> path = new LinkedList<>();
            V v = v2;
            while (v != null) {
                path.add(0, v);
                v = trace.get(v);
            }
            return path;
        }
        return null;
    }
}