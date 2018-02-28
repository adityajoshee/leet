package adityajoshee.Y2K18.feb.D16;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by aditya.joshee on 2/16/18.
 */
public class ConnectedComponents {
    public static void main(String[] args) {
        BiGraph graph = new BiGraph(7);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(5,4);
        findCC(graph);
    }

    private static void findCC(BiGraph graph) {
        int[] visited = new int[graph.v];
        int count = 0;
        for (int i = 0; i < graph.v; i++) {
            if (visited[i]==0){
                count++;
                visit(i, graph, visited);
            }
        }
        System.out.println(count);
    }

    private static void visit(int i, BiGraph graph, int[] visited) {
        Stack<Integer> stack = new Stack();
        stack.push(i);
        visited[i] = 1;
        while (!stack.empty()){
            int curr = stack.pop();

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
            edges = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                edges[i] = new LinkedList<>();
            }
        }

        public void addEdge(int i, int j){

            edges[i].add(j);
            edges[j].add(i);
        }
    }

}
