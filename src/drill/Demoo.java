package drill;

/**
 * Created by adityajoshee on 05/03/16.
 */
public class Demoo {


    public static void main(String args[]){
        print(1);
    }

    private static void print(int n){
        if(n>100){
            return ;
        }
        System.out.println(n++);
        print(n);
    }
}
