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
        int visited[] = new int[dag.adj.length];
        LinkedList<Integer> sortedList = new LinkedList<>();
        for (int i = 0; i < dag.adj.length; i++) {
            if (visited[i]==0){
                visitDag(dag, i, visited,sortedList);
            }
        }
        return sortedList;
    }
    private static void visitDag(DirectedGraph dag, int currentVertex, int[] visited, LinkedList<Integer> sortedList){
        visited[currentVertex] = 1;
        Iterator<Integer> itr = dag.adj[currentVertex].iterator();
        while (itr.hasNext()){
            int i = itr.next();
            if (visited[i]==0){
                visitDag(dag,i,visited,sortedList);
            }
        }
        sortedList.push(currentVertex);
    }

}
