package adityajoshee.april1517;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.j on 4/15/17.
 */
public class LRU {
    private int CAPACITY;
    private Map<Integer, DLListNode> map;
    private DLListNode head;
    private DLListNode tail;

    public Integer get(Integer key){
        if (map.containsKey(key)){
            if (map.size()==1){
                return head.val;
            }
            DLListNode node = map.get(key);
            node = removeDllNode(node);
            setHead(node);
            return node.val;
        }
        return -1;
    }

    public void set(Integer key, Integer val){
        head = new DLListNode(val, null, head);
        map.put(key, head);
        if (map.size()<=CAPACITY){
            if (map.size()==1){
                tail = head;
                return;
            }
            head.next.pre = head;
        }
        else{
            tail = tail.pre;
            map.remove(tail.next);
            removeDllNode(tail.next);
        }
    }

    private DLListNode removeDllNode(DLListNode node){
        if (node.pre==null){
            head = node.next;
            node.next = null;
            return node;
        }
        if (node.next==null){
            node.pre.next = null;
            tail = node.pre;
            node.pre = null;
            return node;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
        return node;
    }


    private DLListNode setHead(DLListNode node){
        head.pre = node;
        node.next = head;
        node.pre = null;
        head = node;
        return head;
    }

    public LRU(int capacity){
        this.CAPACITY = capacity;
        map = new HashMap<>(capacity);
    }

    class DLListNode{
        Integer val;
        DLListNode pre;
        DLListNode next;

        public DLListNode(Integer val, DLListNode pre, DLListNode next){
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    public static void main(String args[]){
        LRU cache = new LRU(5);
        System.out.println(cache.get(1));
        cache.set(1, 1);
        System.out.println(cache.get(1));
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        cache.set(5, 5);

        System.out.println(cache.get(1));
        cache.set(6,6);
        System.out.println();

    }

}
