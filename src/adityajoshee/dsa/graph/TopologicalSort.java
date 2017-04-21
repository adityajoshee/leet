package adityajoshee.dsa.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by aditya on 11/26/16.
 */
public class TopologicalSort {
    public static void main(String args[]){
        // new directed acyclic graph..
        DirectedGraph dag = new DirectedGraph(6);
        dag.addEdgeFrom(5, 2);
        dag.addEdgeFrom(5, 0);
        dag.addEdgeFrom(0, 4);
        dag.addEdgeFrom(4, 1);
        dag.addEdgeFrom(2, 3);
        dag.addEdgeFrom(1, 3);
        System.out.println(Arrays.toString(topologicalSort(dag).toArray()));
    }
    private static LinkedList<Integer> topologicalSort(DirectedGraph dag){
        boolean visited[] = new boolean[dag.adj.length];
        LinkedList<Integer> topoSortedList = new LinkedList<>();
        for (int i = 0; i < dag.adj.length; i++) {
            if (!visited[i]){
                visitDag(dag, i, visited,topoSortedList);
            }
        }
        return topoSortedList;
    }
    private static void visitDag(DirectedGraph dag, int currentVertex, boolean[] visited, LinkedList<Integer> sortedList){
        visited[currentVertex] = true;
        Iterator<Integer> itr = dag.adj[currentVertex].iterator();
        while (itr.hasNext()){
            int i = itr.next();
            if (!visited[i]){
                visitDag(dag,i,visited,sortedList);
            }
        }
        // all adjacent vertices for currentVertex are visited, so now the currentVertex can be put to dag list.
        sortedList.push(currentVertex);
    }

}
