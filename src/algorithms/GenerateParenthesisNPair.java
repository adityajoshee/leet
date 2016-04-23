package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adityajoshee on 17/04/16.
 */
public class GenerateParenthesisNPair {

    public List<String> generate(int n){
        List<String> resultSet = new ArrayList<>();
        if(n<=0){
            return resultSet;
        }
        System.out.println(helper(0,0,n,"",resultSet) + "valid parenthesis permuations:");

        return resultSet;
    }

    private int helper(int left, int right,int totalPairs, String partial, List<String> resultSet){
        if(left+right==2*totalPairs){
            resultSet.add(partial);
            return 1;
        }
        int a=0,b=0;
        if(left<totalPairs){
            a=helper(left+1,right,totalPairs,partial+"{",resultSet);
        }
        if(right<left){
            b=helper(left,right+1,totalPairs,partial+"}",resultSet);
        }
        return a+b;
    }

    public static void main(String arg[]){
        GenerateParenthesisNPair problem = new GenerateParenthesisNPair();
        List<String> result = problem.generate(3);
        for(String s : result){
            System.out.println(s);
        }
    }


}
