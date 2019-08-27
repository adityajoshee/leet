package adityajoshee.hackerrank;

import java.util.*;

/**
 * Created by aditya.joshee on 2019-08-16.
 */
public class RustAndMurderer {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i=0; i<5; i++){
            g.put(i, new HashSet<>());
        }
        g.get(0).add(1);
        g.get(0).add(2);
        g.get(0).add(3);
        g.get(2).add(0);
        g.get(1).add(0);
        g.get(1).add(4);
        g.get(1).add(3);
        g.get(3).add(0);
        g.get(3).add(1);
        g.get(4).add(1);

        System.out.println(Arrays.toString(rustMurderer(0, g)));
    }
    public static int[] rustMurderer(int s, Map<Integer, Set<Integer>>  roads) {
        int[] shortest = new int[roads.size()];
        boolean[] visited = new boolean[roads.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()){
            int n = q.remove();
            for (int i=0; i<roads.size(); i++){
                if(i!=s && !roads.get(n).contains(i) && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                    shortest[i] = shortest[n]+1;
                }
            }
        }

        return shortest;
    }
}

