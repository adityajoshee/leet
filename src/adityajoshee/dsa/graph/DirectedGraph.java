package adityajoshee.dsa.graph;

import java.util.LinkedList;

/**
 * Created by aditya on 11/26/16.
 */
public class DirectedGraph {
    LinkedList<Integer>[] adj; // adjacency lists for every vertex v
    public DirectedGraph(int vertexCount){
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    public void addEdgeFrom(int v1, int v2){
        if (v1>=0 && v1<adj.length && v2>=0 && v2<adj.length){
            adj[v1].add(v2); // will append v2 to LL at index v1.
            //adj[v2].add(v1); // will append v1 to LL at index v2.
        }
        else {
            System.out.println("Cannot form edge...");
        }
    }

}
