package datastructure.array;

import java.util.Arrays;

/**
 * Created by aditya on 10/7/16.
 */
//http://tutorials.jenkov.com/java-performance/ring-buffer.html

public class RingBuffer {
    int[] arr;
    int capacity;
    int tokenCount = 0;
    int writePos = 0;

    public RingBuffer(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }

    private int getReadPos(){
        int readPos = writePos - tokenCount;
        if(readPos < 0){
            readPos += capacity;
        }
        return readPos;
    }

    public boolean write(int tokenData){
        if(tokenCount == capacity){
            return false;
        }
        arr[writePos] = tokenData;
        tokenCount++;
        writePos++;
        // wrap around the index incase it reaches after last index
        if(writePos == capacity){
            writePos = 0;
        }
        return true;
    }

    public int read(){
        if(tokenCount > 0){
            int retVal = arr[getReadPos()];
            tokenCount--;
            return retVal;
        }
        // no tokens in buffer
        return -1;
    }


    public static void main(String args[]){
        RingBuffer ringBuffer = new RingBuffer(5);
        for (int i = 1; i <= 10; i++) {
            System.out.println(ringBuffer.write(i));
        }
        System.out.println(Arrays.toString(ringBuffer.arr));
        for (int i = 1; i <= 2; i++) {
            System.out.println(ringBuffer.read());
        }
        for (int i = 11; i <= 13; i++) {
            System.out.println(ringBuffer.write(i));
        }
        System.out.println(Arrays.toString(ringBuffer.arr));
        System.out.println(ringBuffer.read());
        System.out.println(ringBuffer.write(14));
        System.out.println(Arrays.toString(ringBuffer.arr));
        System.out.println(ringBuffer.write(15));
        System.out.println(ringBuffer.write(16));
        System.out.println(Arrays.toString(ringBuffer.arr));
    }
}
