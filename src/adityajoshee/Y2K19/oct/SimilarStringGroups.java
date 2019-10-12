package adityajoshee.Y2K19.oct;

/**
 * Created by aditya.joshee on 2019-10-10.
 */


class SimilarStringGroups {

        public static void main(String[] args) {
            System.out.println(new SimilarStringGroups().numSimilarGroups(new String[]{"tars","rats","arts","star"}));
        }

        public int numSimilarGroups(String[] A) {
            UnionFind uf = new UnionFind(A.length);
            for(int i=0; i<A.length-1; i++){
                for(int j=i+1; j<A.length; j++){
                    if(isSimilar(A[i] , A[j] )){
                        uf.union(i, j);
                        if(uf.getNumOfGroups()==1){
                            return 1;
                        }
                    }
                }
            }
            return uf.getNumOfGroups();
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
        boolean isSimilar(String a, String b){
            int n=0;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i)!=b.charAt(i) && ++n==3){
                    return false;
                }
            }
            return true;
        }
}