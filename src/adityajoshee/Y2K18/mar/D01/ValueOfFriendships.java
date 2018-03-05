package adityajoshee.Y2K18.mar.D01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/1/18.
 */
public class ValueOfFriendships {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            UGraph uGraph = new UGraph(n);
            int m = scan.nextInt();
            int valueOfFriendship = 0;
            for (int j = 0; j < m; j++) {
                uGraph.addUEdge(scan.nextInt(), scan.nextInt());
                //sum of sizes of all connected components
                valueOfFriendship = valueOfFriendship + findValue(uGraph);
            }
            System.out.println(valueOfFriendship);
        }
    }

    //slow, as it does dfs very time an edge is added.
    private static int findValue(UGraph uGraph) {
        boolean[] visited = new boolean[uGraph.edges.length];
        int valueOfFriends = 0;
        for (int i = 0; i < uGraph.edges.length; i++) {
            if (!visited[i]){
                Sum sum = new Sum();
                dfs(i, uGraph, visited, sum);
                valueOfFriends = valueOfFriends + sum.val*(sum.val-1);
            }
        }
        return valueOfFriends;
    }

    private static void dfs(int node, UGraph uGraph, boolean[] visited, Sum sum){
        visited[node] = true;
        sum.val++;
        Iterator<Integer> iterator = uGraph.edges[node].iterator();
        while (iterator.hasNext()){
            int nei = iterator.next();
            if (!visited[nei]){
                dfs(nei, uGraph, visited, sum);
            }
        }
    }

    private static class Sum{
        int val;
    }

    private static class UGraph {
        List[] edges ;
        public UGraph(int n){
            edges = new List[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new LinkedList();
            }
        }

        public void addUEdge(int a, int b){
            edges[a].add(b);
            edges[b].add(a);
        }
    }
}
