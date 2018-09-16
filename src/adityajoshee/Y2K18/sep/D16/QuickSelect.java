package adityajoshee.Y2K18.sep.D16;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {11,0,2,5,1,6,4,3};
        int k = 7; //find kth smallest
        System.out.println(arr[find(0, arr.length-1, arr, k-1)]);
    }

    private static int find(int l, int r, int[] arr, int k){
        if (k<l || k>r){
            throw new RuntimeException("invalid k");
        }

        int p = findCorrectPartitionPosition(l, r, arr);
        if (p==k){
            return p;
        }
        if (p<k){
            return find(p+1, r, arr, k);
        }
        else {
            return find(l, p-1, arr, k);
        }
    }

    private static int findCorrectPartitionPosition(int l, int r, int[] arr) {
        int p = r;
        r = r-1;
        while (l<r){
            while (l<r && arr[l]<=arr[p]){
                l++;
            }
            while (l<r && arr[r]>=arr[p]){
                r--;
            }
            if (l<r){
                swap(arr, l++, r--);
            }
        }
        if (arr[l]<arr[p]){
            return p;
        }
        swap(arr, l, p);
        return l;
    }

    private static void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
