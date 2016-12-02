package adityajoshee.practice.ds.ll;

/**
 * Created by aditya on 9/18/16.
 */
public class Reverse {
    public static void main(String args[]){
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 4; i++) {
            linkedList.append(i);
        }
        linkedList.print();
        linkedList.setHead(linkedList.reverse2(linkedList.getHead()));
        linkedList.print();

    }
}
