package adityajoshee.feb20.graph.ds;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aditya.j on 2/20/17.
 */
public class Graph {
    private int v;
    public List<Integer>[] adj;

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
    }

    public void addEdge(Integer i, Integer j, boolean isDirected) throws Exception{
        if (i>=adj.length || j>=adj.length){
            throw new Exception();
        }
        if(adj[i]==null){
            adj[i] = new LinkedList<>();
            adj[i].add(j);
        }
        else{
            Iterator<Integer> iterator = adj[i].iterator();
            while (iterator.hasNext()){
                if (iterator.next()==j){
                    return;
                }
            }
            adj[i].add(j);
            if (!isDirected){
                if (adj[j]==null){
                    adj[j] = new LinkedList<>();
                }
                adj[j].add(i);
            }
        }
    }


    public void printAdjMatrix(){
        for (int i = 0; i < v; i++) {
            if (adj[i]!=null){
                Iterator<Integer> iterator = adj[i].iterator();
                while(iterator.hasNext()){
                    System.out.print(" "+iterator.next());
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws Exception{
        Graph g = new Graph(4);
        g.addEdge(0,1, true);
        g.addEdge(0,2, true);
        g.addEdge(1,2, true);
        g.addEdge(2,0, true);
        g.addEdge(0,3, true);
        g.printAdjMatrix();
    }
}
