package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityajoshee on 23/04/16.
 */
public class TugOfWar {

    public static void main(String args[]){
        int[] forces = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        minSetDiffFinder(new ArrayList(), new ArrayList(),forces,Integer.MAX_VALUE,Integer.MAX_VALUE,0);
    }


    private static void minSetDiffFinder(List f1,List f2,int[] forces,int tempMin, int tempDiff, int current){
        if(f1.size()+f2.size()==forces.length && tempDiff<=tempMin){
            //done
            System.out.println(f1);
            System.out.println(f2);
            return;
        }

        //minSetDiffFinder(f1.add(forces[current]),f2,forces,tempMin<diff(f1,f2)?tempMin:diff(f1,f2),tempDiff+forces[current]+current+1);
        f1.remove(current);
        //minSetDiffFinder(f1.add(forces[current]),f2,forces,tempMin<diff(f1,f2)?tempMin:diff(f1,f2));


    }
}
