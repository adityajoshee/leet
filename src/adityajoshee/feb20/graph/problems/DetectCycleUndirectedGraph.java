package adityajoshee.feb20.graph.problems;

import adityajoshee.feb20.graph.ds.Graph;

import java.util.Iterator;

/**
 * Created by aditya.j on 2/20/17.
 */
public class DetectCycleUndirectedGraph {
    public static void main(String args[]) throws Exception {
        Graph g = new Graph(5);
        g.addEdge(0, 1, false);
        g.addEdge(3, 0, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.printAdjMatrix();
        System.out.println("Has Cycle : " + hasCycle(g));
    }

    public static boolean hasCycle(Graph g) {
        int[] visited = new int[g.adj.length]; // number of nodes in graph g, track the visited nodes.
        int[] stack = new int[g.adj.length];
        for (int i = 0; i < g.adj.length; i++) {
            if (visited[i] != 1) {
                if (visit(g, i, visited, stack, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean visit(Graph g, Integer iNode, int[] visited, int[] stack, int iParent) {
        visited[iNode] = 1;
        stack[iNode] = 1;
        if (g.adj[iNode] != null) {
            Iterator<Integer> iterator = g.adj[iNode].iterator();
            while (iterator.hasNext()){
                int nei = iterator.next();
                // visit all neighbors except the node from which we are getting this neighbor
                if (nei!=iParent){
                    if (stack[nei]==1){
                        return true;
                    }
                    boolean hasCycle = visit(g, nei, visited, stack, iNode);
                    if (hasCycle){
                        return true;
                    }
                }
            }
        }
        stack[iNode]=0;
        return false;
    }
}
