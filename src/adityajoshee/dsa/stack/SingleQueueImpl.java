package adityajoshee.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aditya on 8/17/16.
 */
public class SingleQueueImpl<T> {

    private Queue<T> q = new LinkedList<>();
    public SingleQueueImpl(){
    }
    public static void main(String[] args) {
        SingleQueueImpl<String> s = new SingleQueueImpl<>();
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    public void push(T s){
        q.offer(s);
    }

    public T pop(){
        int n = q.size();
        for(int i = 0; i < n-1; i++){
            q.offer(q.poll()); // will put the head element at tail end.
        }
        // finally the last element will become the first element
        return q.poll();
    }
}
