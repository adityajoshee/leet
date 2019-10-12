package adityajoshee.Y2K19.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by aditya.joshee on 2019-10-11.
 */

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // approach - Create a email-to-name map. Perform union of all emails in an account. Use the same union find struct to perform union for other accounts;

        HashMap<String, String> e2n = new HashMap();
        HashMap<String, Integer> e2id = new HashMap();      // req. for union find

        for(int i=0; i<accounts.size(); i++){
            int id = 0;
            List<String> e = accounts.get(i);
            for(int j=1; j<e.size(); j++){
                e2n.put(e.get(j), e.get(0));
                if(e2id.get(e.get(j))==null){
                    e2id.put(e.get(j), id++);
                }
            }
        }

        UnionFind uf = new UnionFind(e2id.size());

        for(int i=0; i<accounts.size(); i++){
            List<String> e = accounts.get(i);
            for(int j=2; j<e.size(); j++){
                uf.union(e2id.get(e.get(1)), e2id.get(e.get(j)));
            }
        }

        HashMap<Integer, TreeSet<String>> resSet = new HashMap();
        for(String e: e2id.keySet()){
            int id = e2id.get(e);
            int par = uf.findParent(id);
            if(resSet.get(par)==null){
                resSet.put(par, new TreeSet<>());
            }
            resSet.get(par).add(e2n.get(e));
        }
        List<List<String>> res = new ArrayList<>(uf.getNumOfGroups());
        int idx = 0;
        for(int par: resSet.keySet()){
            res.get(idx).add(e2n.get(resSet.get(par).first()));
            res.get(idx).addAll(resSet.get(par));
            idx++;
        }
        return res;
    }


    private class UnionFind{
        int[] parent, rank;
        int groups;
        public int getNumOfGroups(){
            return groups;
        }
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
            rank = new int[n];
            groups = n;
        }

        public void union(int x, int y){
            int px = findParent(x);
            int py = findParent(y);
            if(px==py){
                return;
            }
            if(rank[px]>rank[py]){
                parent[py] = px;
                rank[px]++;
            }
            else{
                parent[px] = py;
                rank[py]++;
            }
            groups--;
        }

        public int findParent(int x){
            while(parent[x]!=x){
                return findParent(parent[x]);
            }
            return x;
        }
    }
}