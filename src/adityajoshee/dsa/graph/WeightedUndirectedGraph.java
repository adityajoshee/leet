package adityajoshee.dsa.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aditya.j on 4/24/17.
 */
public class WeightedUndirectedGraph {
    public List<AdjNode>[] adj;

    public WeightedUndirectedGraph(int noOfVertices){
        adj = new LinkedList[noOfVertices];
    }

    public void addEdge(int a, int b, int wt){
        if (a<adj.length && b<adj.length && a>=0 && b>=0){
            if (adj[a]==null){
                adj[a] = new LinkedList<>();
            }
            adj[a].add(new AdjNode(b, wt));

            if (adj[b]==null){
                adj[b] = new LinkedList<>();
            }
            adj[b].add(new AdjNode(a, wt));
        }
        else{
            System.out.println("ERROR: Cannot form edage:"+a+","+b);
        }
    }

    class AdjNode{
        int wt;
        int v;
        public AdjNode(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
    }
}
