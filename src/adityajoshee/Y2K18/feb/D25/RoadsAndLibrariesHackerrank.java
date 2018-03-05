package adityajoshee.Y2K18.feb.D25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aditya.joshee on 2/25/18.
 */
public class RoadsAndLibrariesHackerrank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt(); // number of cities
            int m = scanner.nextInt(); //number of possible roads
            long clib = scanner.nextLong();
            long croad = scanner.nextLong();
            UndirectedGraph city = new UndirectedGraph(n);
            for (int j = 0; j < m; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                city.edges[u-1].add(v-1);
                city.edges[v-1].add(u-1);
            }
            System.out.println(find(city, n, m, clib, croad));
        }
    }

    private static long find(UndirectedGraph city, int n, int m, long cLib, long cRoad) {
        long cost = 0;
        if (cLib<=cRoad){
            cost =  n*cLib;
        }
        else{
            List<Integer> connectedComponents = findConnectedComponentsSize(city);
            cost = connectedComponents.size()*cLib; // 1 lib per connected component
            for (int i : connectedComponents) {
                cost = cost + (i-1)*cRoad;
            }
            cost = Math.min(cost, n*cLib);
        }
        return cost;
    }

    private static class UndirectedGraph {
        int nodes;
        List<Integer>[] edges;

        public UndirectedGraph(int nodes){
            this.nodes = nodes;
            edges = new ArrayList[nodes];
            for (int i = 0; i < nodes; i++) {
                edges[i] = new ArrayList();
            }
        }
    }

    private static List<Integer> findConnectedComponentsSize(UndirectedGraph city){
        int[] visited = new int[city.edges.length];
        List<Integer> nodeCounts = new ArrayList<>();
        for (int i = 0; i < city.edges.length; i++) {
            if (visited[i]==0){
                // new component
                Counter counter = new Counter();
                dfs(i, city, visited, counter);
                nodeCounts.add(counter.val);
            }
        }
        return nodeCounts;
    }

    private static void dfs(int node, UndirectedGraph graph, int[] visited, Counter counter) {
        visited[node] = 1;
        counter.val++;
        Iterator<Integer> neighborIterator = graph.edges[node].iterator();
        while (neighborIterator.hasNext()){
            int nei = neighborIterator.next();
            if (visited[nei]==0){
                dfs(nei, graph, visited, counter);
            }
        }
    }

    private static class Counter{
        int val = 0;
    }
}
