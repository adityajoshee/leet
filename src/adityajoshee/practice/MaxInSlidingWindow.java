package adityajoshee.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by aditya.joshee on 2019-09-04.
 */
public class MaxInSlidingWindow {
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,1,2,0,5},3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0 || nums.length==0 || nums.length<k) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int j=0;
        while(j<k){ // add initial k elements' index
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[j]){
                deque.removeLast();
            }
            deque.offer(j++);
        }
        // element respresented by the first index in deque is the max for
        // the current window.
        int[] res = new int[nums.length-k+1];
        int r=0;
        res[r++]=nums[deque.peekFirst()];

        while(j<nums.length){
            int l = deque.peekFirst();
            if(l<=j-k){
                deque.pop(); // remove the first index, as it is not part of the current sliding window now.
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[j]){
                deque.removeLast();
            }
            deque.offer(j);
            res[r++]=nums[deque.peekFirst()];
            j++;
        }
        return res;
    }
}
