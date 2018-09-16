package adityajoshee.dsa.array.kthLargest;

/**
 * Created by aditya.j on 4/29/17.
 */
public class KthLargestInTwoSorted {
    public static void main(String args[]){
        int[] a = {5,6,11};
        int[] b = {0,8,9};
        try {
            System.out.println(kthSmallestFastRecur(3,0,0,a.length, b.length,a,b));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    private static int findKthLargest(int[] a, int[] b, int k) throws Exception {
//        if(k<=0 || k>a.length+b.length){
//            throw new Exception("Cannot findMethod1 kth largest!");
//        }
//        int p=0, x=0; // starting index of arrays
//
//        //trim useless part of arrays
//        if (k<a.length){
//            p = a.length-k;
//        }
//        if (k<b.length){
//            x = b.length-k;
//        }
//        return exe(a, p, a.length-1, b, x, b.length-1, k);
//    }

    private static int exe(int[] a, int p, int q, int[] b, int x, int y, int k){

        int alen = q-p+1;
        int blen = y-x+1;
        int mida = p+(q-p)/2;
        int midb = x+(y-x)/2;

        if (alen<=0){
            return b[x+k-1];
        }
        if (blen<=0){
            return a[p+k-1];
        }
        System.out.println("p:"+p+", q:"+q+", x:"+x+", y:"+y+", k:"+k);

        if (k<=(alen+blen)/2){
            if (a[mida]>b[midb]){
                return exe(a,p,q,b,midb+1,y,k);
            }
            else{
                return exe(a,mida+1,q,b,x,y,k);
            }
        }
        else{
            if (a[mida]>b[midb]){
                return exe(a,p,mida,b,x,y,k-(q-mida));
            }
            else{
                return exe(a,p,q,b,x,midb,k-(y-midb));
            }
        }
    }

    private static int kthSmallestFastRecur(int k, int index1, int index2, int size1, int size2, int[] a, int[] b) {

        if (index1 + index2 == k - 1) {
            if (size1 > index1 && (size2 <= index2 || a[index1]<(b[index2]) )) {
                return a[index1];
            } else {
                return b[index2];
            }
        }

        int step = (k - index1 - index2) / 2;
        int step1 = index1 + step;
        int step2 = index2 + step;
        if (size1 > step1 - 1 && (size2 <= step2 - 1 || a[step1 - 1]<(b[step2 - 1]) )) {
            index1 = step1;
        } else {
            index2 = step2;
        }
        return kthSmallestFastRecur(k, index1, index2, size1, size2, a, b);
    }
}
