package adityajoshee.Y2K18.mar.D04;

import java.util.*;

/**
 * Created by aditya.joshee on 3/4/18.
 *
 * input to test
 6 7
 1 2 1
 2 3 1
 3 4 3
 3 6 2
 3 5 6
 4 6 1
 5 6 8
 */
public class PrimMinimumSpanningTree {

    //find weight of MST
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        WeightedUG wug = new WeightedUG(N);
        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            wug.addEdge(scanner.nextInt()-1, scanner.nextInt()-1, scanner.nextInt());
        }
        System.out.println(mst(wug));
    }

    private static int mst(WeightedUG wug) {
        Set<Integer> unvisitedSet = new HashSet<>();
        boolean[] visited = new boolean[wug.neighors.length];
        int[] minDistanceFromMST = new int[wug.neighors.length];
        Arrays.fill(minDistanceFromMST, Integer.MAX_VALUE);
        int totalMstWt = 0;
        PriorityComparator priorityComparator = new PriorityComparator();
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(priorityComparator);

        for (int j = 0; j < wug.neighors.length; j++) {
            unvisitedSet.add(j);  // add all to unvisited set initially
        }

        // visit starting node as 0
        priorityQueue.add(new Pair(0, 0));
        minDistanceFromMST[0]=0;
        while (!unvisitedSet.isEmpty()){ // while there are nodes still left to visit
            Pair nearestNeighbor = priorityQueue.poll();
            unvisitedSet.remove(nearestNeighbor.element);
            visited[nearestNeighbor.element]=true;
            totalMstWt = totalMstWt + nearestNeighbor.weight;

            Iterator<Pair> iterator = wug.neighors[nearestNeighbor.element].iterator();
            while (iterator.hasNext()){
                Pair neighbor = iterator.next();
                if (!visited[neighbor.element]){
                    if (minDistanceFromMST[neighbor.element] > neighbor.weight){
                        minDistanceFromMST[neighbor.element] = neighbor.weight;
                        priorityQueue.remove(neighbor);
                        priorityQueue.add(neighbor); // remove and add on PQ can be clubbed into single function decrease-key to reduce complexity
                    }
                }
            }
        }
        return totalMstWt;
    }

    private static class WeightedUG{
        List<Pair>[] neighors;

        public WeightedUG(int N){
            neighors = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                neighors[i] = new LinkedList();
            }
        }
        public void addEdge(int a, int b, int w){
            neighors[a].add(new Pair(w, b));
            neighors[b].add(new Pair(w, a));
        }
    }

    public static class Pair{
        int weight;
        int element;
        public Pair(int weight, int element){
            this.weight = weight;
            this.element = element;
        }

        @Override
        public boolean equals(Object o) {
            return ((Pair)o).element == this.element;
        }

        @Override
        public int hashCode() {
            int result = weight;
            result = 31 * result + element;
            return result;
        }
    }

    public static class PriorityComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.weight - o2.weight;
        }
    }
}
