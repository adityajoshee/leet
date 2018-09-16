package adityajoshee.practice;

/**
 * Created by aditya.j on 4/29/17.
 */
public class kthlargestIn2Sortd {
    public static void main(String args[]){
        int[] a= {4,5,6};
        int[] b = {1,2,3};
        try {
            System.out.println(findKthLargest(a,b,4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findKthLargest(int[] a, int[] b, int k) throws Exception {
        if(k<=0 || k>a.length+b.length){
            throw new Exception("Cannot findMethod1 kth largest!");
        }
        int p=0, x=0; // starting index of arrays

        //trim useless part of arrays
        if (k<a.length){
            p = a.length-k;
        }
        if (k<b.length){
            x = b.length-k;
        }
        return exe(a, p, a.length-1, b, x, b.length-1, k);
    }
    public static int exe(int[] a, int p, int q, int[] b, int x, int y, int k){
        int asize = q-p+1;
        int bsize = y-x+1;

        //base cases
        if (asize==0){
            return b[y-k+1];
        }
        if (bsize==0){
            return a[q-k+1];
        }
        if (k==1){
            return Math.max(a[q],b[y]);
        }

        int mida = p + (q-p)/2;
        int midb = x + (y-x)/2;

        int leftMida = mida - p;
        int rightMida = q - mida;
        int leftMidb = midb - x;
        int rightMidb = y - midb;

        if (a[mida]>b[midb]){
//            if (k-1 == 1 + rightMida + rightMidb){
//                return b[midb];
//            }
            if (k-1 > rightMida){
                return  exe(a, p, mida, b, x, y, k-(rightMida));
            }
            else {
                return  exe(a, mida+1, q, b, midb+1, y, k);
            }
        }
        else {
//            if (k-1 == 1 + rightMida + rightMidb){
//                return a[mida];
//            }
            if (k-1 > rightMidb){
                return  exe(a, p, q, b, x, midb, k-(rightMidb));
            }
            else {
                return  exe(a, mida+1, q, b, midb+1, y, k);
            }
        }
    }













    public static int findKth(int A[], int p1, int r1, int B[], int p2, int r2, int k) {
        int n1 = r1 - p1 + 1;
        int n2 = r2 - p2 + 1;

        //base cases
        if (n1 == 0) {
            return B[r2-k];
        }
        if (n2 == 0) {
            return A[p2-k];
        }
        //
        if (k == 0) {
            return Math.max(A[p1], B[p2]);
        }

        //select two index i,j from A and B respectively such that If A[i] is between B[j] and B[j-1]
        //Then A[i] would be the i+j+1 smallest element because.
        //Therefore, if we choose i and j such that i+j = k-1, we are able to findMethod1 the k-th smallest element.
        int i = n1 / (n1 + n2) * k;//let's try to chose a middle element close to kth element in A
        int j = k - 1 - i;

        //add the offset
        int mid1 = Math.min(p1 + i, r1);
        int mid2 = Math.min(p2 + j, r2);

        //mid1 is greater than mid2. So, median is either in A[p1...mid1] or in B[mid2+1...r2].
        //we have already see B[p2..mid2] elements smaller than kth smallest
        if (A[mid1] > B[mid2]) {
            k = k - (mid2 - p2 + 1);
            r1 = mid1;
            p2 = mid2 + 1;
        }
        //mid2 is greater than or equal mid1. So, median is either in A[mid1+1...r1] or in B[p2...mid2].
        //we have already see A[p1..mid1] elements smaller than kth smallest
        else {
            k = k - (mid1 - p1 + 1);
            p1 = mid1 + 1;
            r2 = mid2;
        }

        return findKth(A, p1, r1, B, p2, r2, k);
    }
}