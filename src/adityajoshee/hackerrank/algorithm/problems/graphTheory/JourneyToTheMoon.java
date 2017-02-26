package adityajoshee.hackerrank.algorithm.problems.graphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by aditya.j on 2/24/17.
 */
public class JourneyToTheMoon {
    private static int groupIndex = 0;

    public static void main(String args[]) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String[] s = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int P = Integer.parseInt(s[1]);
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        DisjointSets disjointSets = new DisjointSets(N);
        for (int i = 0; i < P; i++) {
            String[] pair = bufferedReader.readLine().split(" ");
            disjointSets.union(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]));
        }
        System.out.println(calculateWays(disjointSets));
    }

    static long calculateWays(DisjointSets disjointSets){
        long[] arr = new long[disjointSets.numOfDS];
        int e=0;
        for (int i = 0; i < disjointSets.count.length; i++) {
            if (disjointSets.parent[i]==i){
                arr[e++]=disjointSets.count[i];
            }
        }
        long ways=0;
        long curr;
        for (int i = 0; i < arr.length-1; i++) {
            curr = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                ways+=curr*arr[j];
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
            numOfDS=N;
            for (int i = 0; i < N; i++) {
                parent[i]=i;
                count[i]=1;
            }
        }

        void union(int i, int j){
            int irp = find(i);
            int jrp = find(j);
            if (irp==jrp){
                return;
            }
            if (rank[irp]>rank[jrp]){
                rank[irp]++;
                parent[jrp] = irp;
                count[irp]+=count[jrp];
            }
            else {
                rank[jrp]++;
                parent[irp] = jrp;
                count[jrp]+=count[irp];
            }
            numOfDS--;
        }

        int find(int i){
            if (parent[i]==i){
                return i;
            }
            return find(parent[i]);
        }
    }

}