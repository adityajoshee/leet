package adityajoshee.Y2K18.feb.D16;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by aditya.joshee on 2/16/18.
 */
public class BFS {
    public static void main(String[] args) {
        BiGraph graph = new BiGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        graph.addEdge(5,4);
        graph.addEdge(1,5);
        bfsexe(graph);
    }

    private static void bfsexe(BiGraph graph) {
        int[] visited = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {   // vertices will be from 0 to v-1
            if (visited[i]==0){
                visit(i, graph, visited);
            }
        }
    }

    private static void visit(int i, BiGraph graph, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = 1;
        queue.add(i);

        while (!queue.isEmpty()){
            int currNode = queue.poll();
            System.out.print(currNode+" ");
            for (int e: graph.edges[currNode]){
                if (visited[e]==0){
                    visited[e] = 1;
                    queue.add(e);
                }
            }
        }
    }

    private static class BiGraph{
        // vertices will be from 0 to v-1
        Integer v;
        List<Integer>[] edges;

        public BiGraph(Integer v) {
            this.v = v;
        }

        public void addEdge(int i, int j){
            if (edges==null){
                edges = new LinkedList[v];
            }
            if (edges[i]==null){
                edges[i] = new LinkedList<>();
            }
            if (edges[j]==null){
                edges[j] = new LinkedList<>();
            }
            edges[i].add(j);
            edges[j].add(i);
        }
    }
}
