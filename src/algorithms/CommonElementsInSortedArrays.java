package algorithms;

/**
 * Created by aditya.joshee on 21/09/14.
 */


/*
Find commons elements in three sorted arrays...
 */
public class CommonElementsInSortedArrays {
    public static void main(String... args){
        int[] ar1 = {1, 5, 10, 20, 40, 80};
        int [] ar2 = {6, 7, 20, 80, 100};
        int[] ar3= {3, 4, 15, 20, 30, 70, 80, 120};
        find(ar1,ar2,ar3);
    }

    private static void find(int[] a,int[] b,int[] c){
        int x=0,y=0,z=0;
        for(int i=0;i<50;i++){
            if(a[x]==b[y] && b[y]==c[z]){
                System.out.print(a[x]+" ");
                if(x<a.length-1)x++;
                if(y<b.length-1)y++;
                if(z<c.length-1)z++;
            }
            else{
                if(a[x]<b[y]){
                    if(x<a.length-1)
                        x++;
                }
                else if(b[y]<c[z]){
                    if(y<b.length-1)
                        y++;
                }
                else{
                    if(z<c.length-1)
                        z++;
                }
            }
        }
    }
}
