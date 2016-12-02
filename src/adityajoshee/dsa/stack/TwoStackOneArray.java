package adityajoshee.dsa.stack;

/**
 * Created by adityajoshee on 29/04/16.
 */
public class TwoStackOneArray {

    private static  int defaultCombinedCapacity = 10;
    private int[] arr;
    private int sizeOfLeftStack=0;
    private int sizeOfRightStack=0;

    public static void main(String args[]){
        TwoStackOneArray stacks = new TwoStackOneArray(10);
        stacks.addToLeftStack(0);
        stacks.addToLeftStack(1);
        stacks.addToRightStack(100);
        stacks.addToLeftStack(2);
        stacks.addToLeftStack(3);
        stacks.addToRightStack(200);
        stacks.addToLeftStack(4);
        stacks.addToLeftStack(5);
        stacks.addToRightStack(300);
        stacks.addToRightStack(400);
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromLeftStack();
        stacks.popFromRightStack();
        stacks.popFromRightStack();
        stacks.popFromRightStack();

        stacks.popFromRightStack();

        stacks.popFromRightStack();
        stacks.addToLeftStack(5);
        stacks.addToRightStack(500);
        stacks.addToRightStack(600);

        stacks.printStacks();



    }

    public TwoStackOneArray(){
        this(defaultCombinedCapacity);
    }

    public int freeSpace(){
        return arr.length-sizeOfLeftStack-sizeOfRightStack;
    }

    public TwoStackOneArray(int combinedCapacity){
        arr  = new int[combinedCapacity];
    }
    public boolean addToLeftStack(int item){
        if(freeSpace()>0){
            sizeOfLeftStack=sizeOfLeftStack+1;
            arr[sizeOfLeftStack-1]=item;
            return true;
        }
        System.out.println("No free space to add : "+item);
        return false;
    }
    public boolean addToRightStack(int item){
        if(freeSpace()>0){
            arr[arr.length-1-sizeOfRightStack]=item;
            sizeOfRightStack=sizeOfRightStack+1;
            return true;
        }
        System.out.println("No free space to add : "+item);
        return false;
    }

    public int popFromLeftStack(){
        if(sizeOfLeftStack>0){
            int itemToPop = arr[sizeOfLeftStack-1];
            arr[sizeOfLeftStack-1]=-1;
            sizeOfLeftStack=sizeOfLeftStack-1;
            return itemToPop;
        }
        System.out.println("Nothing to pop from left stack ");

        return -1;
    }

    public int popFromRightStack(){
        if(sizeOfRightStack>0){
            int itemToPop = arr[arr.length-1-sizeOfRightStack];
            arr[arr.length-1-sizeOfRightStack]=-1;
            sizeOfRightStack=sizeOfRightStack-1;
            return itemToPop;
        }
        System.out.println("Nothing to pop from right stack : ");

        return -1;
    }

    public void printStacks(){
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
