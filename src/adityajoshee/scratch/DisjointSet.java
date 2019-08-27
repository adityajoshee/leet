package adityajoshee.scratch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by aditya.joshee on 2019-07-21.
 */
public class DisjointSet {
    int numOfDisjointSets;
    int[] parent;
    int[] size;
    int[] rank;

    public DisjointSet(int n){
        numOfDisjointSets=n; //initially
        // n is the number of members
        parent = new int[n];
        size = new int[n];
        rank = new int[n];

        //initially rank of all members=1 and parent=member index
        for (int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    public void union(int x, int y){
        int px = findParent(x);
        parent[x]=px;
        int py = findParent(y);
        parent[y]=py;
        if (px!=py) {
            if (rank[px] >= rank[py]){
                parent[py] = px;
                rank[px]++;
                size[px]=size[px]+size[py];
            }
            else {
                parent[px] = py;
                rank[py]++;
                size[py]=size[py]+size[px];
            }
            numOfDisjointSets--;
        }
    }

    public int findParent(int x){
        System.out.println("calling findParent for "+ x);
        if (parent[x]!=x){
            return findParent(parent[x]);
        }
        return x;
    }

    public void print(){
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(rank));
        System.out.println(Arrays.toString(size));
        System.out.println(numOfDisjointSets);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DisjointSet disjointSet = new DisjointSet(6);
        while (true){
            try {
                String[] strs = reader.readLine().split(" ");
                disjointSet.union(Integer.valueOf(strs[0]), Integer.valueOf(strs[1]));
                disjointSet.print();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
