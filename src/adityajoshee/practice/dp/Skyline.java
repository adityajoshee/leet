package adityajoshee.practice.dp;

import java.util.*;

/**
 * Created by aditya.joshee on 2019-08-18.
 */
public class Skyline {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{0,5,1}, {1,3,3}, {2,4,2}, };
        for (List<Integer> list: skyline(buildings)){
            System.out.println(list.toString());
        }
    }
    private static List<List<Integer>> skyline(int[][] buildings) {
        List<List<Integer>> sky = new LinkedList<>();
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        TreeMap<Integer, Integer> ends = new TreeMap<>();
        for(int i=0; i<buildings.length; i++){
            int[] build = buildings[i];
            starts.put(build[0], i); // sorted by left ends of buildings
            ends.put(build[1], i); //sorted by rights ends of buildings

        }
        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());
        while(!starts.isEmpty() && !ends.isEmpty()){
            int s = starts.firstKey();
            int e = ends.firstKey();
            if(s<=e){
                if(heights.isEmpty() || heights.peek() < buildings[starts.get(s)][2]){
                    List<Integer> point = Arrays.asList(s, buildings[starts.get(s)][2]);
                    sky.add(point);
                }
                heights.add(buildings[starts.get(s)][2]);
                starts.remove(s);
            }
            else{
                if(heights.peek() < buildings[ends.get(e)][2]){
                    List<Integer> point = Arrays.asList(e, buildings[ends.get(e)][2]);
                    sky.add(point);
                }
                heights.remove( buildings[ends.get(e)][2]);
                ends.remove(e);
            }
        }
        while (!ends.isEmpty()){
            int e = ends.firstKey();
            heights.poll();
            if(!heights.isEmpty() && heights.peek() < buildings[ends.get(e)][2]) {
                List<Integer> point = Arrays.asList(e, heights.peek());
                sky.add(point);
            }
            ends.remove(e);
        }
        return sky;
    }
}
