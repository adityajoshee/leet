package adityajoshee.Y2K18.jan.D23;

/**
 * Created by aditya.joshee on 1/23/18.
 * How to reverse a string using without any other variable.
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] str = "adityaJoshee".toCharArray();
        System.out.println(reverse(str));
    }
    private static char[] reverse(char[] str){
        int l = 0;
        int r = str.length-1;

        while (l<r){
            str[l] = (char)(str[l]^str[r]);
            str[r] = (char)(str[l]^str[r]);
            str[l] = (char)(str[l]^str[r]);
            l++;
            r--;
        }
        return str;
    }
}
