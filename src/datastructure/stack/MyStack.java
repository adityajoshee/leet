package datastructure.stack;

/**
 * Created by adityajoshee on 29/04/16.
 */
public class MyStack<T extends Object> {

    private T[] arr;
    private static int defaultSize = 10;
    private int size;
    private int capacity;

    public MyStack(){
        this(defaultSize);
        capacity=defaultSize;
        System.out.println("Stack Created with capacity : "+defaultSize);
        size=0;
    }

    public MyStack(int capacity){
        arr = (T[])new Object[capacity];
        this.capacity=capacity;
        size=0;
        System.out.println("Stack Created with capacity : "+capacity);
    }

    public void printCurrentStack(){
        System.out.println("Printing Stack Bottom to Top:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public boolean isFull(){
        if(this.size==capacity){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        return false;
    }

    public T peek(){
        if(size>0){
            return arr[size-1];
        }
        System.out.println("Stack already empty...can't peek.");
        return null;
    }

    public T pop(){
        if(!isEmpty()){
            T poppedItem = arr[size-1];
            arr[size-1]=null;
            size=size-1;
            return poppedItem;
        }
        System.out.println("Stack already empty...can't pop.");
        return null;
    }

    public boolean push(T itemToAdd){
        if(size<capacity){
            size=size+1;
            arr[size-1]=itemToAdd;
            System.out.println("Added item to stack :"+itemToAdd);
            return true;
        }
        System.out.println("Stack Full...can't add items.");
        return false;
    }
}
