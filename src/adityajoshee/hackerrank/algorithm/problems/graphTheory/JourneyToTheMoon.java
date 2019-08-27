package adityajoshee.hackerrank.algorithm.problems.graphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by aditya.j on 2/24/17.
 */
//https://www.hackerrank.com/challenges/journey-to-the-moon
public class JourneyToTheMoon {
    private static int groupIndex = 0;

    public static void main(String args[]) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String[] s = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int P = Integer.parseInt(s[1]);
        DisjointSets disjointSets = new DisjointSets(N);
        for (int i = 0; i < P; i++) {
            String[] pair = bufferedReader.readLine().split(" ");
            disjointSets.union(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]));
        }
        System.out.println(calculateWays(disjointSets));
    }

    static long calculateWays(DisjointSets disjointSets){
        long[] setSizes = new long[disjointSets.numOfDS];
        int e=0;
        for (int i = 0; i < disjointSets.count.length; i++) {
            if (disjointSets.parent[i]==i){
                setSizes[e++]=disjointSets.count[i];
            }
        }
        long ways=0;
        long curr;
        for (int i = 0; i < setSizes.length-1; i++) {
            curr = setSizes[i];
            for (int j = i+1; j < setSizes.length; j++) {
                ways+=curr*setSizes[j];
            }
        }
        return ways;
    }
    static class DisjointSets{
        int[] parent, rank, count;
        int numOfDS=0;
        public DisjointSets(int N){
            parent = new int[N];
            count = new int[N];
            rank = new int[N];
            // initially num of disjoint sets will be N
            numOfDS=N;
            // parent of the node will be itself
            for (int i = 0; i < N; i++) {
                parent[i]=i;
                count[i]=1;
            }
        }

        // group 2 nodes, perform a union operation (application - add edge to two nodes in a un-graph)
        void union(int i, int j){
            int iParent = findParent(i);
            int jParent = findParent(j);

            if (iParent==jParent){
                // both nodes are already in same set, so return
                return;
            }
            if (rank[iParent]>rank[jParent]){ // using union by rank here (another option is union by size)
                // put node j's parent in the group containing i
                // increase i's parent rank
                rank[iParent]++;
                parent[jParent] = iParent;
                count[iParent]+=count[jParent];
            }
            else {
                // put node i's parent in the group containing j
                // increase j's parent rank
                rank[jParent]++;
                parent[iParent] = jParent;
                count[jParent]+=count[iParent];
            }
            // now one set has been merged into another so decrease count of disjoint sets.
            numOfDS--;
        }

        int findParent(int i){
            // recurse until the parent of the node is the node itself
            if (parent[i]==i){
                return i;
            }
            return findParent(parent[i]);
        }
    }

}