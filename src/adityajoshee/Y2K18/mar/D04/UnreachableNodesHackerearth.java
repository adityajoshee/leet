package adityajoshee.Y2K18.mar.D04;

import java.util.*;

/**
 * Created by aditya.joshee on 3/4/18.
 */
public class UnreachableNodesHackerearth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        UnGraph unGraph = new UnGraph(N);
        for (int i = 0; i < M; i++) {
            unGraph.addEdges(scanner.nextInt()-1, scanner.nextInt()-1);
        }
        int x = scanner.nextInt();
        boolean[] visited = new boolean[N];
        Sum sum = new Sum();
        find(unGraph, x-1, visited, sum);
        System.out.println(N-sum.val);
        System.out.println(N-dfsStack(unGraph, x-1));
    }

    private static void find(UnGraph unGraph, int x, boolean[] visited, Sum sum) {
        visited[x] = true;
        sum.val++;
        Iterator<Integer> iterator = unGraph.edges[x].iterator();
        while(iterator.hasNext()){
            int nei = iterator.next();
            if (!visited[nei]){
                find(unGraph, nei, visited, sum);
            }
        }
    }

    private static class Sum{
        int val;
    }

    private static class UnGraph{
        List<Integer>[] edges;
        public UnGraph(int n){
            edges = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new LinkedList<>();
            }
        }
        public void addEdges(int a, int b){
            edges[a].add(b);
            edges[b].add(a);
        }
    }

    private static int dfsStack(UnGraph unGraph, int x){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[unGraph.edges.length];
        stack.push(x);
        int sum = 0;
        while (!stack.empty()){
            int popped = stack.pop();
            sum++;
            visited[popped] = true;
            Iterator<Integer> iterator = unGraph.edges[popped].iterator();
            while (iterator.hasNext()){
                int nei = iterator.next();
                if (!visited[nei]){
                    visited[nei] = true;
                    stack.push(nei);
                }
            }
        }
        return sum;
    }
}
