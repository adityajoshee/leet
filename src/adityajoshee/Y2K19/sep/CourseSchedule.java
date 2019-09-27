package adityajoshee.Y2K19.sep;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by aditya.joshee on 2019-09-16.
 */
public class CourseSchedule {
    public boolean canFinish(int n, int[][] prereq) {

        //create a graph from prerequisites. If there are not cycles in the graph then ans is yes.
        int[][] graph = new int[n][n];

        for(int[] pair: prereq){
            graph[pair[1]][pair[0]] = 1; // since edge is from y->x in every pair(x,y)
        }

        Stack<Integer> stack = new Stack(); // for DFS
        boolean[] visited = new boolean[n];
        Set<Integer> currStackNodes = new HashSet<>();

        for(int i=0; i<n; i++){
            if(!visited[i] && isCyclic(i, graph, currStackNodes, stack, visited)){
                return false;
            }
        }
        return true;
    }
    private boolean isCyclic(int n, int[][] graph, Set<Integer> currStackNodes, Stack<Integer> stack, boolean[] visited){
        if(currStackNodes.contains(n)){
            return true;
        }
        currStackNodes.add(n);
        // visit neighbors
        for (int nei=0; nei<graph[n].length; nei++){
            if(graph[n][nei]==1){ // it is a neighbor, so push to recursion stack
                if(isCyclic(nei, graph, currStackNodes, stack, visited)){
                    return true;
                }
            }
        }
        // all neighbor of n are now visited, so mark visited
        visited[n] = true;
        currStackNodes.remove(n);
        return false;
    }
}