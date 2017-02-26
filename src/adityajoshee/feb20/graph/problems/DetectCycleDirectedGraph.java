package adityajoshee.feb20.graph.problems;

import adityajoshee.feb20.graph.ds.Graph;

import java.util.Iterator;

/**
 * Created by aditya.j on 2/20/17.
 */
public class DetectCycleDirectedGraph {
    public static void main(String args[]) throws Exception{
        Graph g = new Graph(5);
        g.addEdge(0,1, true);
        g.addEdge(0,2, true);
        g.addEdge(2,3, true);
        g.addEdge(1,3, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 0, true);
        //g.addEdge(3,0);
        g.printAdjMatrix();
        System.out.println("Has Cycle : "+ hasCycle(g));
    }

    public static Boolean hasCycle(Graph g){
        int[] visited = new int[g.adj.length]; // number of nodes in graph g, track the visited nodes.
        int[] stack = new int[g.adj.length];
        for (int i = 0; i < g.adj.length; i++) {
            if (visited[i]!=1){
                if(visit(g, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean visit(Graph g, Integer iNode, int[] visited, int[] stack){
        visited[iNode]=1;
        stack[iNode]=1;
        if (g.adj[iNode]!=null){
            Iterator<Integer> iterator = g.adj[iNode].iterator();
            while(iterator.hasNext()){
                Integer neighbor = iterator.next();
                if(stack[neighbor]==1){
                    return true;
                }
                Boolean hasCycle = visit(g, neighbor, visited, stack);
                if (hasCycle){
                    return true;
                }
            }
        }
        stack[iNode]=0;
        return false;
    }
}