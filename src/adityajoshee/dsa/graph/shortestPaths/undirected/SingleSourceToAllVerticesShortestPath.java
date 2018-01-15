package adityajoshee.dsa.graph.shortestPaths.undirected;

import adityajoshee.dsa.graph.WeightedUndirectedGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aditya.j on 4/24/17.
 */
public class SingleSourceToAllVerticesShortestPath {
    public static void main(String args[]){
        WeightedUndirectedGraph graph = new WeightedUndirectedGraph(4);
        graph.addEdge(0,1,2);
        graph.addEdge(0,2,1);
        graph.addEdge(1,3,2);
        graph.addEdge(3,2,1);
        graph.addEdge(0,3,3);
        System.out.println(Arrays.toString(find(graph,0)));
    }
    private static int[] find(WeightedUndirectedGraph graph, int source){
        int[] dist = new int[graph.adj.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0; // distance of source from itself is 0.
        Queue queue = new LinkedList();
        queue.add(source);
        while(!queue.isEmpty()){
            //TODO
        }
        return null;
    }
}
