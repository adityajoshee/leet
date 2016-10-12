package hackerrank.ds.problems.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/9/16.
 */
public class Qheap {
    public static void main(String args[]) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int n = Integer.parseInt(br.readLine());
        MyHeap myHeap = new MyHeap(100000);
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            if(inputs.length==1){
                System.out.println(myHeap.getMin());
            }
            else if(inputs[0].equals("1")){
                myHeap.add(Long.parseLong(inputs[1]));
            }
            else {
                myHeap.del(Long.parseLong(inputs[1]));
            }
            //myHeap.printArr();

        }
    }
    static class MyHeap{
        private long[] arr = new long[0];
        private int size = 0;
        private int cap = 0;

        public void printArr(){
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }

        public MyHeap(int cap){
            this.cap = cap;
            this.arr = new long[cap];
        }
        public void add(long x){
            if(size<=cap){
                arr[size] = x;
                siftUp(size);
                size++;
            }
        }
        public void del(long x){
            int delPos = find(x);
            arr[delPos] = arr[size-1];
            size -= 1;
            siftDown(delPos);
        }
        public int find(long x){
            for (int i = 0; i < size; i++) {
                if(arr[i]==x){
                    return i;
                }
            }
            return -1; // will not occur as per ques statement
        }
        public long getMin(){
            if(arr.length>0)
                return arr[0];
            return Integer.MIN_VALUE;
        }
        private void swap(long[] arr, int x, int y){
            long t = arr[x];
            arr[x] = arr[y];
            arr[y] = t;
        }
        private void siftUp(int index){
            while(arr[index] < arr[getParentIndex(index)]){
                int parentIndex = getParentIndex(index);
                swap(arr, index, parentIndex);
                index = parentIndex;
            }
        }
        private void siftDown(int index){
            int k = isSiftDownReq(index);
            while(k!=-1){
                swap(arr, index, k);
                index = k;
                k = isSiftDownReq(index);
            }
        }
        private int isSiftDownReq(int index){
            int l = getLeftChildIndex(index);
            int r = getRightChildIndex(index);
            if(l==-1 && r==-1){
                return -1;
            }

            if(r==-1)
                return arr[l]<arr[index]?l:-1;

            if(arr[l]<arr[index] || arr[r]<arr[index]){
                return arr[l]<arr[r]?l:r;
            }
            return -1;
        }
        private int getLeftChildIndex(int index){
            return (2*index+1)>=size?-1:(2*index+1);
        }
        private int getRightChildIndex(int index){
            return (2*index+2)>=size?-1:(2*index+2);
        }
        private int getParentIndex(int childIndex){
            if((childIndex-1)/2>=0){
                return (childIndex-1)/2;
            }
            return Integer.MIN_VALUE;
        }
    }
}
