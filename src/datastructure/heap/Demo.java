package datastructure.heap;


/*
8,2,4,0,9,3,1,7
0,1,2,3,4,5,6,7
 */


public class Demo {
	public static void main(String[] args){

        int arr[]={8,2,4,0,9,3,1,7};
        buildHeap(arr);
        int x = 0;
        while(x<arr.length){
            System.out.print(arr[x]+" ");
            x++;
        }
	}


    private static void  buildHeap(int[] inputArray){
        int tempParentIndex = (inputArray.length-1)/2;
        while(tempParentIndex>=0){
            siftDown(inputArray, tempParentIndex);
            tempParentIndex--;
        }
    }

    private static void siftDown(int[] arr, int nodeIndex){

        while(nodeIndex<arr.length){

            int leftChildIndex = (nodeIndex*2)+1;
            int rightChildIndex = (nodeIndex*2)+2;

            int tempMinIndex = nodeIndex;
            if(leftChildIndex<arr.length && arr[tempMinIndex]>arr[leftChildIndex]){
                tempMinIndex=leftChildIndex;
            }
            if(rightChildIndex<arr.length && arr[tempMinIndex]>arr[rightChildIndex]){
                tempMinIndex=rightChildIndex;
            }
            if(tempMinIndex!=nodeIndex){
                swap(arr,tempMinIndex,nodeIndex);
                nodeIndex=tempMinIndex;
            }
            else{
                break;
            }
        }
    }

    private static void swap(int[] arr,int x, int y){
        int tmp = arr[x];
        arr[x]=arr[y];
        arr[y]=tmp;
    }
}
