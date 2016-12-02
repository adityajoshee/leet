package adityajoshee.dsa.matrix;

import java.util.Arrays;

/**
 * Created by aditya on 11/21/16.
 */
/*
http://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/
 */
public class PrintSortedMatrixLinearForm {
    public static void main(String args[]) throws Exception {
        int[][] matrix = {  {10, 20, 30, 40},
                            {15, 25, 35, 45},
                            {27, 29, 37, 48},
                            {32, 33, 39, 50},
        };
        System.out.println(Arrays.toString(convert(matrix)));
    }
    private static int[] convert(int[][] matrix) throws Exception {
        int[] sortedArr = new int[matrix.length*matrix[0].length]; // final sorted array
        MinHeap minHeap = new MinHeap(matrix.length); // used for left element of all rows
        int k = 0;
        // put 1st element of all rows to init minheap
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new HeapElement(i,0,matrix[i][0]));
        }

        while (minHeap.size>0){
            HeapElement e = minHeap.pop();
            sortedArr[k++] = e.v;
            if (e.j<matrix[0].length-1){
                minHeap.add(new HeapElement(e.i, e.j+1, matrix[e.i][e.j+1]));
            }
        }

        return sortedArr;
    }
    private static class MinHeap{
        HeapElement arr[];
        int maxSize;
        int size = 0;
        public MinHeap(int maxSize){
            this.maxSize = maxSize;
            arr = new HeapElement[maxSize];
        }
        boolean add(HeapElement e){
            if (size<maxSize){
                arr[size] = e;
                size++;
                siftUp();
                return true;
            }
            return false;
        }

        HeapElement pop() throws Exception{
            if (size>0){
                HeapElement retVal = arr[0];
                if (size>1){
                    arr[0] = arr[size-1];
                    size--;
                    siftDown(0);
                }
                else {
                    size--;
                }
                return retVal;
            }
            throw new Exception();
        }

        void siftUp(){
            int i = size-1;
            int pi =  (i-1)/2 ;

            while(pi>=0 && arr[pi].v>arr[i].v){
                //need to sift up child...
                swap(arr, i, pi);
                i = pi;
                pi = (i-1)/2;
            }
        }

        void siftDown(int i){
            int lci = 2*i+1;
            int rci = 2*i+2;
            while((lci<size && arr[lci].v<arr[i].v) || (rci<size && arr[rci].v<arr[i].v)){
                int s = getSwapInd(i,lci,rci);
                swap(arr, i, s);
                i = s;
                lci = 2*i+1;
                rci = 2*i+2;
            }
        }

        void swap(HeapElement[] arr, int x, int y){
            HeapElement t = arr[x];
            arr[x] = arr[y];
            arr[y] = t;
        }

        int getSwapInd(int i,int lci,int rci){
            int min = i;
            if (lci<size && arr[lci].v<arr[min].v){
                min = lci;
            }
            if (rci<size && arr[rci].v<arr[min].v){
                min = lci;
            }
            return min;
        }
    }
    static class HeapElement{
        int i;
        int j;
        int v; // can also be found by referencing the matrix
        public HeapElement(int i, int j, int v){
            this.i = i;
            this.j = j;
            this.v = v;
        }
    }
}
