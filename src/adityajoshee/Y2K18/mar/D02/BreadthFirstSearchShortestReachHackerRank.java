package adityajoshee.Y2K18.mar.D02;

import java.util.*;

/**
 * Created by aditya.joshee on 3/2/18.
 */
public class BreadthFirstSearchShortestReachHackerRank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            UGraph uGraph = new UGraph(n);
            for (int j = 0; j < m; j++) {
                uGraph.addEdge(scanner.nextInt()-1, scanner.nextInt()-1);  // since our indices are from 0
            }
            int s = scanner.nextInt();
            int[] distances = new int[n];
            boolean[] visited = new boolean[n];
            findShortest(s-1, uGraph, distances, visited); // since our indices are from 0
            for (int j = 0; j < distances.length; j++) {
                if (j!=s-1 && distances[j]!=0){
                    System.out.print(distances[j]+" ");
                }
                if (j!=s-1 && distances[j]==0){
                    System.out.print(-1+" ");
                }
            }
            System.out.println();
        }
    }

    private static void findShortest(int s, UGraph uGraph, int[] distances, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        distances[s] = 0;
        while (!queue.isEmpty()) {
            int popped = queue.poll();
            Iterator<Integer> iterator = uGraph.edges[popped].iterator();
            while (iterator.hasNext()) {
                int nei = iterator.next();
                if (!visited[nei]){
                    visited[nei] = true;
                    queue.add(nei);
                    distances[nei] = distances[popped]+6;
                }
            }
        }
    }

    private static class UGraph{
        List<Integer>[] edges;
        public UGraph(int n){
            edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new LinkedList<>();
            }
        }
        public void addEdge(int a, int b){
            edges[a].add(b);
            edges[b].add(a);
        }
    }
}