package adityajoshee.Y2K19.oct;

import java.util.*;

/**
 * Created by aditya.joshee on 2019-10-12.
 */

class LexicallySmallestStringWithSwaps {
    public static void main(String[] args) {
        List<List<Integer>> swaps = new ArrayList<>();
        swaps.add(new ArrayList<>());
        swaps.get(0).add(2);
        swaps.get(0).add(0);
        swaps.add(new ArrayList<>());
        swaps.get(1).add(1);
        swaps.get(1).add(2);
        System.out.println(new LexicallySmallestStringWithSwaps().smallestStringWithSwaps("udy", swaps));
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length()); //nodes in union-find graph will be indexes of string
        for(List<Integer> p: pairs){
            uf.union(p.get(0), p.get(1));  //swappable indices are become part of same connected component
        }
        //for each connected component in uf, sort the chars. Map sorted char list to either superparent
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            int p = uf.find(i);
            if(map.get(p)==null){
                map.put(p, new PriorityQueue());
            }
            map.get(p).offer((int)s.charAt(i));
        }
        StringBuffer sb = new StringBuffer(s.length());
        for(int i=0; i<s.length(); i++){
            int par = uf.find(i);
            sb.append((char)(int)(map.get(par).poll()));
        }
        return sb.toString();
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