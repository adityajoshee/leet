package adityajoshee.Y2K18.mar.D03;

import java.util.*;

/**
 * Created by aditya.joshee on 3/3/18.
 */
public class GraphNodesAtLevelHackerearth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        UndGraph undGraph = new UndGraph(n);
        for (int i = 0; i < n-1; i++) {
            undGraph.addEdge(scanner.nextInt()-1, scanner.nextInt()-1 );
        }
        int x = scanner.nextInt();
        System.out.println(findNodesAtLevel(undGraph, x));
    }

    private static int findNodesAtLevel(UndGraph undGraph, int x) {
        boolean[] visited = new boolean[undGraph.edges.length];
        int[] level = new int[undGraph.edges.length];
        level[0] = 1;
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int countOfNodesAtLevelX = 0;
        while (!queue.isEmpty()){
            int popped = queue.poll();
            if (level[popped]==x){
                countOfNodesAtLevelX++;
            }
            else {
                Iterator<Integer> iterator = undGraph.edges[popped].iterator();
                while (iterator.hasNext()){
                    int nei = iterator.next();
                    if (!visited[nei]){
                        visited[nei] = true;
                        level[nei] = level[popped]+1;
                        queue.add(nei);
                    }
                }
            }
        }
        return countOfNodesAtLevelX;
    }

    private static class Sum{
        int val;
    }

    public static class UndGraph{
        List[] edges;
        public UndGraph(int n){
            edges = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new LinkedList();
            }
        }
        public void addEdge(int a, int b){
            edges[a].add(b);
            edges[b].add(a);
        }
    }
}
