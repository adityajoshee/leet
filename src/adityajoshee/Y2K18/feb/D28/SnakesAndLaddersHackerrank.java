package adityajoshee.Y2K18.feb.D28;

import java.util.*;

/**
 * Created by aditya.joshee on 2/28/18.
 */
public class SnakesAndLaddersHackerrank {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            DirectedGraph directedGraph = new DirectedGraph(100);
            // add ladder edges

            //add next 6 moves as edges
            for (int j = 0; j < 100; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j+k<100){
                        directedGraph.addEdgeFromTo(j,j+k);
                    }
                }
            }

            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                int s = scanner.nextInt()-1;
                int d = scanner.nextInt()-1;
                directedGraph.removeAllEdgesFrom(s);
                directedGraph.addEdgeFromTo(s, d);
            }
            // add snake edges
            int m = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                int s = scanner.nextInt()-1;
                int d = scanner.nextInt()-1;
                directedGraph.removeAllEdgesFrom(s);
                directedGraph.addEdgeFromTo(s, d);
            }


            boolean[] visited = new boolean[directedGraph.edges.length];
            int[] distances = new int[directedGraph.edges.length];
            System.out.println(findShortestPath(0, 99, directedGraph, visited, distances));

        }
    }

    private static int findShortestPath(int source, int dest, DirectedGraph directedGraph, boolean[] visited, int[] distances) {
        // for directed unweighted graph, shortest path from a to b node can be found by BFS from a.
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        while (!queue.isEmpty()){
            int popped = queue.poll();
            visited[popped] = true;
            if (popped==dest){
                return distances[popped];
            }
            Iterator<Integer> iterator = directedGraph.edges[popped].iterator();
            while (iterator.hasNext()){
                // add neighbors to queue
                int node = iterator.next();
                if (!visited[node]){
                    queue.add(node);
                    if (popped-node>6 || node-popped>6){
                        //snake or ladder edge
                        distances[node] = distances[popped];
                    }
                    if (distances[node]==0){
                        distances[node] = distances[popped]+1;
                    }
                    else {
                        distances[node] = Math.min(distances[node], distances[popped]+1);
                    }
                }
            }
        }
        return -1;
    }

    public static class DirectedGraph{
        List[] edges ;

        public DirectedGraph(int nodes){
            edges = new List[nodes];
            for (int i = 0; i < nodes; i++) {
                edges[i] = new LinkedList();
            }
        }
        public void addEdgeFromTo(int s, int d){
            edges[s].add(d);
        }
        public void removeAllEdgesFrom(int s){
            edges[s] = new LinkedList();
        }
    }
}
