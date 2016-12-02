package adityajoshee.dsa.graph;

import java.util.Iterator;

/**
 * Created by aditya on 11/26/16.
 */
public class DetectCycleUndirected {
    public static void main(String args[]){
        int vertexCount = 5;
        UndirectedGraph g = new UndirectedGraph(vertexCount);
        g.addEdgeBetween(1, 0);
        g.addEdgeBetween(1, 2);
        g.addEdgeBetween(2, 0);
        g.addEdgeBetween(0, 3);
        //g.addEdgeBetween(2, 4);
        g.addEdgeBetween(3, 4);
        System.out.println(hasCycle(g));
    }
    private static boolean hasCycle(UndirectedGraph g){
        int[] visited = new int[g.adj.length];
        for (int i = 0; i < g.adj.length; i++) { // this loop is required is the graph is not connected
            if (visited[i]==0){
                if(visit(g, i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    // returns true if g has a cycle
    private static boolean visit(UndirectedGraph g, int currVertex, int[] visited, int parent){
        visited[currVertex] = 1;
        int i;
        Iterator<Integer> itr = g.adj[currVertex].iterator();
        while(itr.hasNext()){
            i = itr.next();
            if (visited[i]==1 && i!=parent){
                return true;
            }
            if (visited[i]!=1 && visit(g,i,visited,currVertex)){
                return true;
            }
        }
        return false;
    }
}