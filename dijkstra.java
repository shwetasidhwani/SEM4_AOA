import java.util.*;

public class dijkstra {
    static final int INF = 100000;

    public void Dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n]; // array to store shortest distances
        boolean[] visited = new boolean[n];// array to mark visited nodes
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);// initialize all distances to infinite
        dist[source] = 0;// distance of source from source is 0
        for (int i = 0; i < n; i++) {

            int u = minDistance(dist, visited);// selecting the vertex with minimum distance
            visited[u] = true;// mark the vertex as visited

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance of " + source + " to " + i + " is " + dist[i]);
        }
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int minDist = INF;
        int minVertex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                { 0, 2, 0, 1, 0 },
                { 2, 0, 4, 3, 0 },
                { 0, 4, 0, 0, 6 },
                { 1, 3, 0, 0, 5 },
                { 0, 0, 6, 5, 0 },
        };
        dijkstra ob = new dijkstra();
        ob.Dijkstra(graph, 0);
    }
}
