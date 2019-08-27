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
        boolean[] visited = new boolean[g.adj.length];
        for (int i = 0; i < g.adj.length; i++) {
            if (!visited[i]){
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()){
                    Integer n = queue.remove();
                    System.out.print(n+" ");
                    if (g.adj[n]!=null){
                        Iterator<Integer> iterator = g.adj[n].iterator();
                        while (iterator.hasNext()){
                            int nei = iterator.next();
                            if (!visited[nei]){
                                visited[nei]=true;
                                queue.add(nei);
                            }
                        }
                    }
                }
            }
        }
    }


}