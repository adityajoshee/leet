package adityajoshee.Y2K19;

/**
 * Created by aditya.joshee on 2019-08-23.
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c#","ad#c#"));
    }
    public static boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int p=0,q=0;
        for(int i=0, h=0; i<s.length; i++,h=0){
            while(i<s.length && s[i]!='#'){
                s[p]=s[i];
                i++;p++;
            }
            while(i<s.length && s[i]=='#'){
                h++;i++;
            }
            p = Math.max(0, i-2*h);
        }

        for(int i=0, h=0; i<t.length; i++,h=0){
            while(i<t.length && t[i]!='#'){
                t[q]=t[i];
                i++;q++;
            }
            while(i<t.length && t[i]=='#'){
                h++;i++;
            }
            q = Math.max(0, i-2*h);
        }
        if(q!=p) return false;
        for(int i=0; i<p; i++){
            if(s[i]!=t[i]) return false;
        }
        return true;

    }
}
