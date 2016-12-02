package adityajoshee.dsa.datastructure.heap;

/**
 * Created by aditya on 9/21/16.
 */

// incoming stream of numbers, we have to output the count
// of numbers less than the currently added number.
public class CountOfSmallerElements {
    public static void main(String args[]){
        int stream[]={0,2,4,8,9,3,1,7};
        int size = stream.length;
        HeapNode[] heap = new HeapNode[size];
        for (int i = 0; i < stream.length; i++) {
            System.out.println(getCountOfLower(i, stream[i], heap));
        }
    }
    private static int getCountOfLower(int lastIndex, int num, HeapNode[] heap){
        heap[lastIndex] = new HeapNode(num);
        int newPos = addToHeap(heap, lastIndex);
        return heap[newPos].lcount;
        //return getLcount(heap, newPos, lastIndex);
    }

    // using this approach would have resulted in n*(logn + n)
    private static int getLcount(HeapNode[] heap, int pos, int lastIndex){
        int lpos = pos*2+1;
        int rpos = pos*2+2;
        if(lpos > lastIndex){
            return 0;
        }
        if(rpos > lastIndex){
            return 1 ;
        }
        else{
            return 2+getLcount(heap,lpos,lastIndex) + getLcount(heap,rpos,lastIndex);
        }
    }
    // using this approach resulted in n*(logn)
    private static int getLcountOptm(HeapNode[] heap, int pos, int lastIndex){
        int lpos = pos*2+1;
        int rpos = pos*2+2;
        if(lpos > lastIndex){
            return 0;
        }
        if(rpos > lastIndex){
            return 1 + heap[lpos].lcount ;
        }
        else{
            return 2+heap[lpos].lcount + heap[rpos].lcount;
        }
    }
    private static class HeapNode{
        int val;
        int lcount;

        public HeapNode(int val) {
            this.val = val;
        }
    }
    private static int addToHeap(HeapNode[] heap, int pos){
        int lastIndex = pos;
        int parentPos = (pos-1)/2;
        if(parentPos < 0){
            return pos;
        }
        heap[parentPos].lcount = getLcountOptm(heap, parentPos, pos);
        while (heap[parentPos].val < heap[pos].val){
            swap(heap, pos, parentPos);
            heap[pos].lcount = getLcountOptm(heap, pos , lastIndex);
            heap[parentPos].lcount = getLcountOptm(heap, parentPos, lastIndex);
            pos = parentPos;
            parentPos = (pos-1)/2;
            if(parentPos < 0){
                return pos;
            }
        }
        return pos;
    }
    private static void swap(HeapNode[] heap, int x, int y){
        HeapNode t = heap[x];
        heap[x] = heap[y];
        heap[y] = t;
    }
}
