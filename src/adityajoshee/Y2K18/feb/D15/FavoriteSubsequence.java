package adityajoshee.Y2K18.feb.D15;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by aditya.joshee on 2/15/18.
 *
 * You are given a String
 S
 S of length
 N
 N.

 Now, a good subsequence is one that can be represented in the form
 a
 i
 b
 j
 c
 k
 aibjck, where
 i
 ≥
 1
 i≥1,
 j
 ≥
 1
 j≥1 and
 k
 ≥
 1
 k≥1. For example ,if
 i
 =
 2
 i=2,
 j
 =
 1
 j=1,
 k
 =
 3
 k=3, it represents the string
 a
 a
 b
 c
 c
 c
 aabccc. In short, a good subsequence is a subsequence that first consist of
 i
 i
 ′
 a
 ′
 ′a′ characters, followed by
 j
 j
 ′
 b
 ′
 ′b′ characters, followed by
 k
 k
 ′
 c
 ′
 ′c′ characters, where
 i
 ≥
 1
 i≥1,
 j
 ≥
 1
 j≥1 and
 k
 ≥
 1
 */
public class FavoriteSubsequence {
    public static void main(String[] args) {
        String s = "abcabc"; // 123123
        System.out.println(find(s.toCharArray()));
    }

    private static int find(char[] str) {
        int count = 0;
        int prev;

        for (int i = 0; i < str.length - 2; i++) {
            if (str[i]=='a'){
                prev = i;
                int next = prev+1;

                do{
                    int highers = 0;
                    prev = i;
                    int p = nextEqualOrHigher(str, next, str[i]);
                    if (p>0){
                        next = p+1;
                    }
                    else {
                        continue;
                    }
                    while (p>0){
                        if (str[p]>str[prev]){
                            highers++;
                        }
                        else{// equal

                        }
                        prev = p;
                        p = nextEqualOrHigher(str, prev+1, str[prev]);
                    }
                    if (highers==2){
                        count++;
                    }
                }
                while (next<str.length);
            }
        }
        return count;
    }

    private static int nextEqualOrHigher(char[] str, int x, char c){
        while (x<str.length){
            if (str[x]>=c){
                return x;
            }
            x++;
        }
        return -1;
    }
}
