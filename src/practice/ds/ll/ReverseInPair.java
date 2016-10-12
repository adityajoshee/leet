package practice.ds.ll;

/**
 * Created by aditya on 9/18/16.
 */
public class ReverseInPair {
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 8; i++) {
            linkedList.append(i);
        }
        linkedList.print();
        linkedList.setHead(linkedList.reverseInPair());
        linkedList.print();
    }
}
