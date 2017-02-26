package adityajoshee.dsa.graph.disjointSets;

/**
 * Created by aditya.j on 2/25/17.
 */
public class DisjoinSetDataStructure {

    int[] parent, rank;

    public DisjoinSetDataStructure(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
        }
        rank = new int[size];
    }

    public static void main(String args[]){
        DisjoinSetDataStructure ds  = new DisjoinSetDataStructure(6);
        ds.union(0,1);
        ds.union(2,3);
        ds.union(1,2);
        ds.union(3,4);
        ds.union(4,5);
        System.out.println(ds.find(1));
    }

    void union(int x, int y){
        int r1 = find(x);
        int r2 = find(y);
        if (rank[r1]>rank[r2]){
            rank[r1]++;
            parent[r2] = r1;
        }
        else {
            rank[r2]++;
            parent[r1] = r2;
        }
    }

    int find(int x){
        while (parent[x]!=x){
            return find(parent[x]);
        }
        return parent[x];
    }

}
