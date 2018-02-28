package adityajoshee.Y2K18.feb.D16;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by aditya.joshee on 2/16/18.
 */
public class DFS {
    public static void main(String[] args) {
        BiGraph graph = new BiGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        graph.addEdge(5,4);
        graph.addEdge(1,5);
        dfsexe(graph);
    }

    private static void dfsexe(BiGraph graph) {
        int[] visited = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            if (visited[i]==0){
                visit(i, graph, visited);
            }
        }
    }

    private static void visit(int i, BiGraph graph, int[] visited) {
        Stack<Integer> stack = new Stack();
        stack.push(i);
        visited[i] = 1;
        while (!stack.empty()){
            int curr = stack.pop();
            System.out.print(curr);

            for (int e: graph.edges[curr]){
                if (visited[e] == 0) {
                    stack.push(e);
                    visited[e] = 1;
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
