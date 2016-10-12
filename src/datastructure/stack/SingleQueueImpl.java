package datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aditya on 8/17/16.
 */
public class SingleQueueImpl<T> {


        /**
         * @param args
         */
        private Queue<T> q = new LinkedList<T>();
        public SingleQueueImpl(){
        }
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            SingleQueueImpl<String> s = new SingleQueueImpl<String>();
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
                System.out.println(q);

                q.offer(q.poll());
                System.out.println(q);

            }
            return q.poll();
        }
}
