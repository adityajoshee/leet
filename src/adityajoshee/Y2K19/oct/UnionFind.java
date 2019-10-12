package adityajoshee.Y2K19.oct;

/**
 * Created by aditya.joshee on 2019-10-10.
 */
public class UnionFind {
    private int[] p, rank;
    private int groups;

    public UnionFind(int nodes){
        p = new int[nodes];
        groups = nodes;
        for (int i = 0; i < nodes; i++) {
            p[i] = i;
        }
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py) {    // already part of same super parent (same group)
            return;
        }
        if (rank[px]>rank[py]){
            p[py] = px;
            rank[px]++;
        }
        else{
            p[px] = py;
            rank[py]++;
        }
        groups--;

    }
    public int find(int x){
        if (p[x]==x){ // super parent condition
            return x;
        }
        return find(p[x]); // go to immediate parent
    }

}
