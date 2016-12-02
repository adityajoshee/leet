package adityajoshee.hackerrank.ds.problems.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/9/16.
 */
public class JesseAndCookies {
    public static void main(String args[]) throws IOException{
        InputStreamReader inputStreamReader  = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String[] strings = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        Heap heap = new Heap(1000000);
        String[] inputs = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            heap.insert(Integer.parseInt(inputs[i]));
        }
        heap.print();
        System.out.println(noOfOpsReq(heap,k));

    }
    private static int noOfOpsReq(Heap heap, int minSweetnessUnit){
        int ops = 0;
        while(heap.peek() < minSweetnessUnit){
            ops++;
            int a = heap.pop();
            int b = heap.pop();
            if(a==-1 || b==-1){
                return -1;
            }
            int mixed = mix(a,b);
            heap.insert(mixed);
            heap.print();;
        }
        return ops;
    }
    private static int mix(int a, int b){
        return (1*a)+(b*2);
    }
    private static class Heap{
        private int[] arr;
        private int size = 0;
        private int cap = 0;
        public Heap(int cap){
            this.cap = cap;
            arr = new int[cap];
        }
        public void print(){
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        public boolean insert(int x){
            if(size>=cap){
                return false;
            }
            arr[size] = x;
            heapifyUp(size++);
            return true;
        }
        private void heapifyUp(int index){
            int pi = parentIndex(index);
            while(pi>=0 && arr[pi] > arr[index]){
                swap(arr, pi, index);
                index = pi;
                pi = parentIndex(index);
            }
        }
        private void swap(int[] arr, int x, int y){
            int t = arr[x];
            arr[x] = arr[y];
            arr[y] = t;
        }
        private int parentIndex(int childIndex){
            if(childIndex==0){
                return -1;
            }
            return (childIndex-1)/2;
        }
        public int pop(){
            if(size==0){
                return -1;
            }
            int popped = arr[0];
            arr[0] = arr[size-1];
            size--;
            heapifyDown(0);
            return popped;
        }
        private void heapifyDown(int index){
            int k = findSwapElement(index);
            while(k!=-1){
                swap(arr, k, index);
                index = k;
                k = findSwapElement(index);
            }
        }
        private int findSwapElement(int index){
            int ret = -1;
            if(findLeft(index)==-1 && findRight(index)==-1){
                return ret;
            }
            else if(findRight(index)==-1){
                ret = arr[findLeft(index)]<arr[index]?findLeft(index):ret;
            }
            else if(arr[findLeft(index)]<arr[index] || arr[findRight(index)]<arr[index]){
                ret = arr[findLeft(index)]<arr[findRight(index)]?findLeft(index):findRight(index);
            }
            return ret;
        }
        private int findLeft(int i){
            int l = 2*i + 1;
            if(l>=size){
                l = -1;
            }
            return l;
        }
        private int findRight(int i){
            int r = 2*i + 2;
            if(r>=size){
                r = -1;
            }
            return r;
        }
        public int peek(){
            if(size>0){
                return arr[0];
            }
            return Integer.MIN_VALUE;
        }
    }
}
