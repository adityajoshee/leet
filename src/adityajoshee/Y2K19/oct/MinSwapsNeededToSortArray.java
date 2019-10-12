package adityajoshee.Y2K19.oct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-10-12.
 */
public class MinSwapsNeededToSortArray {
    public static void main(String[] args) {
        System.out.println(new MinSwapsNeededToSortArray().find(new int[]{6,2,1,3,4,5,7,0}));
    }

    private int find(int[] arr) {
        UnionFind uf = new UnionFind(arr.length);
        for(int i=0; i<arr.length; i++){
            uf.union(i, arr[i]);
        }
        Map<Integer, Integer> parSetSizes = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int p = uf.find(i);
            parSetSizes.put(p, parSetSizes.getOrDefault(p, 0) + 1);
        }
        int swaps = 0;
        for (int k: parSetSizes.keySet()){
            swaps = swaps+parSetSizes.get(k)-1;
        }
        return swaps;
    }
    private class UnionFind{
        int[] parent, rank;
        int groups;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
            groups = n;
        }
        void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px==py){
                return; // since parent are already same, means same group
            }
            if(rank[px] > rank[py]){
                rank[px]++;
                parent[py] = px;
            }
            else{
                rank[py]++;
                parent[px] = py;
            }
        }
        int find(int x){
            while(parent[x]!=x){
                return find(parent[x]);
            }
            return x;
        }
    }
}
