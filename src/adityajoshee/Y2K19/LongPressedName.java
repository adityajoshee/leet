package adityajoshee.Y2K19;

/**
 * Created by aditya.joshee on 2019-08-23.
 */
public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex","aaleex"));
    }
    public static boolean isLongPressedName(String n, String t) {
        char[] name=n.toCharArray();
        char[] typed=t.toCharArray();
        for(int i=0, c=1, j=0; i<name.length; i++){
            while(i<name.length-1 && name[i]==name[i+1]){
                System.out.println(c+"-");
                c++;i++;
            }
            //in typed the name[i] char should be atleast c frequent
            while(j<typed.length && typed[j]==name[i]){
                System.out.println(c);
                c--;j++;
            }
            System.out.println();

            if(c>0) return false;
            c=1;
        }
        return true;
    }
}
