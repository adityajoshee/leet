package adityajoshee.Y2K18.mar.D06;

import java.util.*;

/**
 * Created by aditya.joshee on 3/6/18.
 */
public class MinSpanningTreeWeightKruskal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        UndirectedWeightedGraph graph =new UndirectedWeightedGraph(N);
        int M = scanner.nextInt();
        List<Edge> edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            int w = scanner.nextInt();
            edges.add(new Edge(a, b, w));
            graph.addEdge(a, b, w);
        }
        Collections.sort(edges);
        System.out.println(getMstWeight(graph, edges));
    }

    private static int getMstWeight(UndirectedWeightedGraph graph, List<Edge> edges) {
        int mstWt = 0;
        UnionFindDS unionFindDS = new UnionFindDS(graph.neighbours.length);
        Set<Integer> visited = new HashSet<>();
        while (!edges.isEmpty()){
            Edge edge = edges.get(0); // minimum wt edge
            edges.remove(edge);

            if (unionFindDS.findParent(edge.a) != unionFindDS.findParent(edge.b)){
                // only if a & b belong to different sets...consider the edge in MST and union of a,b
                visited.add(edge.a);
                visited.add(edge.b);
                unionFindDS.union(edge.a, edge.b);
                mstWt = mstWt + edge.w;
            }
        }
        return mstWt;
    }

    private static class UndirectedWeightedGraph{
        List<Neighbour>[] neighbours;
        public UndirectedWeightedGraph(int N){
            neighbours = new List[N];
            for (int i = 0; i < N; i++) {
                neighbours[i] = new LinkedList<>();
            }
        }
        public void addEdge(int a, int b, int w){
            neighbours[a].add(new Neighbour(b, w));
            neighbours[b].add(new Neighbour(a, w));
        }
    }

    private static class Neighbour{
        int val;
        int edgeWt;

        public Neighbour(int val, int edgeWt) {
            this.val = val;
            this.edgeWt = edgeWt;
        }
    }

    private class PriorityComparator implements Comparator<Neighbour> {
        @Override
        public int compare(Neighbour o1, Neighbour o2) {
            return o1.edgeWt - o2.edgeWt;
        }
    }

    private static class Edge implements Comparable{
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            return this.a == ((Edge)o).a && this.b == ((Edge)o).b ;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + w;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            return this.w - ((Edge)o).w;
        }
    }


    private static class UnionFindDS{
        int[] parent;
        int[] rank;
        public UnionFindDS(int N){
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i; // everyone's parent is self
            }
        }

        public void union(int a, int b){
            int pa = findParent(a);
            int pb = findParent(b);
            if (rank[pa]> rank[pb]){ //rank comparison to reduce complexity to Ologn instead of On
                parent[pb] = pa;
                rank[pa]++;
            }
            else {
                parent[pa] = pb;
                rank[pb]++;
            }
        }

        public int findParent(int a){
            int pa = parent[a];
            while (pa != parent[pa]){
                pa = parent[pa];
            }
            return pa;
        }
    }
}