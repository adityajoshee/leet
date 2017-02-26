package adityajoshee.feb20.graph.stdalgo;

import adityajoshee.feb20.graph.ds.Graph;

import java.util.Iterator;

/**
 * Created by aditya.j on 2/22/17.
 */
public class DFS {
    public static void main(String args[]) throws Exception {
        Graph g = new Graph(5);
        g.addEdge(0,1, true);
//        g.addEdge(2,1, true);
        g.addEdge(1,2, true);
        g.addEdge(1,3, true);
        g.addEdge(3,1, true);
        g.addEdge(1,4, true);
        g.addEdge(2,3, true);
        g.addEdge(3,0, true);

        exe(g);
    }

    private static void exe(Graph g) {
        int[] visited = new int[g.adj.length];
        for (int i = 0; i < g.adj.length; i++) {
            if (visited[i]!=1){
                visit(g, visited, i);
            }
        }
    }

    private static void visit(Graph g, int[] visited, int i){
        visited[i]=1;
        System.out.println("Visiting:"+i);
        if (g.adj[i]!=null){
            Iterator<Integer> iterator  = g.adj[i].iterator();
            while(iterator.hasNext()){
                int neig = iterator.next();
                if (visited[neig]!=1){
                    visit(g, visited, neig);
                }
            }
        }
    }
}
