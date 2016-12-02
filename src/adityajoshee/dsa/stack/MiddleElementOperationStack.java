package adityajoshee.dsa.stack;

import java.util.Random;

/**
 * Created by aditya on 11/30/16.
 */
public class MiddleElementOperationStack {
    public static void main(String args[]) throws Exception{
        Random r = new Random();
        SpecialStack specialStack = new SpecialStack();
        for (int i = 0; i < 5; i++) {
            int x = r.nextInt(50);
            specialStack.push(x);
            System.out.print(x+" -> ");
            System.out.println(specialStack.getMidValue());
        }
        specialStack.pop();
        specialStack.pop();
        System.out.println(specialStack.getMidValue());
    }
    static class SpecialStack{
        /*
            DLL will be used to maintain a stack and
            perform operations. top is the reference
            to the Dll node added in the end.
         */
        DllNode top;
        DllNode mid;
        int size;
        void push(int e){
            size++;
            if (top==null){
                top = new DllNode(e);
                mid = top;
            }
            else {
                DllNode oldTop = top;
                top = new DllNode(e);
                oldTop.next = top;
                top.prev = oldTop;
                if (size%2==1){
                    mid = mid.next;
                }
            }
        }

        int pop() throws Exception{
            if (top!=null) {
                size--;
                DllNode oldTop = top;
                top = oldTop.prev;
                if (top!=null){
                    top.next = null;
                }
                oldTop.prev = null;
                if (size%2==1) {
                    mid = mid.prev;
                }
                return oldTop.data;
            }
            throw new Exception();
        }

        int getMidValue(){
            return mid.data;
        }

        void delMid(){
            remove(mid);
        }

        void remove(DllNode node){
            if (node==null){
                return;
            }
            if (node.prev!=null && node.next!=null){
                DllNode pn = node.prev;
                DllNode nn = node.next;
                pn.next = nn;
                nn.prev = pn;
            }
            else {
                if (node.prev==null){
                    if(node.next!=null){
                        node.next.prev = null;
                    }
                }
                if (node.next==null){
                    if (node.prev != null) {
                        node.prev.next = null;
                    }
                }
            }
        }
    }
    static class DllNode{
        DllNode prev;
        DllNode next;
        int data;
        public DllNode(int data){
            this.data = data;
        }
    }
}
