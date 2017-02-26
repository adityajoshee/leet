package adityajoshee.feb20.graph.stdalgo;

import adityajoshee.feb20.graph.ds.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aditya.j on 2/22/17.
 */
public class BFS {
    public static void main(String args[]) throws Exception {
        Graph g = new Graph(4);
        g.addEdge(0,1, true);
        g.addEdge(2,1, true);
        g.addEdge(1,3, true);
        g.addEdge(2,0, true);
        exe(g);
    }
    private static void exe(Graph g){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[g.adj.length];
        for (int i = 0; i < g.adj.length; i++) {
            if (visited[i]!=1){
                visit(g,i,visited,queue);
            }
        }
    }

    private static void visit(Graph g, int inode, int[] visited,Queue queue){
        visited[inode] = 1;
        queue.add(inode);

        while (!queue.isEmpty()){
            Integer hnode = (Integer) queue.poll();
            System.out.print(hnode+" ");
            if (g.adj[hnode]!=null){
                Iterator<Integer> iterator = g.adj[hnode].iterator();
                while (iterator.hasNext()){
                    int cnode = iterator.next();
                    if (visited[cnode]!=1){
                        visited[cnode]=1;
                        queue.add(cnode);
                    }
                }
            }
        }
    }
}