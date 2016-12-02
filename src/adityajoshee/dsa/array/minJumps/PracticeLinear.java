package adityajoshee.dsa.array.minJumps;

/**
 * Created by aditya on 10/17/16.
 */
public class PracticeLinear {
    public static void main(String args[]){
        int[] jumpSet = {1,2,1,1,1};//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};//
        System.out.println(find(jumpSet));
    }

    private static int find(int[] jumps){
        int maxReach = 0+jumps[0];
        int currentCap = jumps[0];
        int steps = 0;
        for (int i = 1; i < jumps.length; i++) {
            System.out.print(maxReach);
            System.out.print(" "+currentCap);
            System.out.println(" "+steps);

            if (maxReach < i+jumps[i]){
                maxReach = i+jumps[i];
            }
            currentCap--;
            if (currentCap==0){
                steps++;
                currentCap = maxReach-i;
            }
        }
        return maxReach>jumps.length?steps+1:steps;
    }
}