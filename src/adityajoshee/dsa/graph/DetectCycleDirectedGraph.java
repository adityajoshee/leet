package adityajoshee.dsa.graph;

import java.util.Iterator;

/**
 * Created by aditya on 11/26/16.
 */
public class DetectCycleDirectedGraph {
    public static void main(String args[]){
        DirectedGraph g = new DirectedGraph(4);
        g.addEdgeFrom(0,1);
        g.addEdgeFrom(0,2);
        g.addEdgeFrom(1,3);
        g.addEdgeFrom(2,3);
        g.addEdgeFrom(3,0);

        System.out.println(hasCycle(g));
    }
    private static boolean hasCycle(DirectedGraph dg){
        int[] visited = new int[dg.adj.length]; // to track visited nodes
        int[] stack = new int[dg.adj.length]; // to track current trail/path of nodes
        for (int i = 0; i < dg.adj.length; i++) {
            if (visited[i]!=1){
                if (visit(dg, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean visit(DirectedGraph dg, int currentVertex, int[] visited, int[] stack){
        visited[currentVertex] = 1;
        stack[currentVertex] = 1;
        int i;
        Iterator<Integer> itr = dg.adj[currentVertex].iterator();
        while (itr.hasNext()){
            i = itr.next();
            if (stack[i]==1){
                return true;
            }
            if(visited[i]!=1){
                if(visit(dg, i, visited,stack)){
                    return true;
                }
            }
        }
        stack[currentVertex] = 0;
        return false;
    }
}
