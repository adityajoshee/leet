package adityajoshee.design;

/**
 * Created by aditya.joshee on 24/08/14.
 */
import java.util.HashMap;

public class LRU {
    private HashMap<Integer, DoubleLinkedListNode> map
            = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int capacity;
    private int len;

    public LRU(int capacity) {
        this.capacity = capacity;
        len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }

    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = cur.pre;
        DoubleLinkedListNode post = cur.next;

        if (pre != null) {
            pre.next = post;
        }
        else { // nothing is before the node getting removed.
            head = post;
        }

        if (post != null) {
            post.pre = pre;
        }
        else { // nothing is after the node getting removed.
            end = pre;
        }
    }

    public void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }

        head = node;
        if (end == null) {
            end = node;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);  // since currently accessed node must come to head of DLL
        }
        else {
            DoubleLinkedListNode newNode =
                    new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(newNode); // since currently accessed node must come to head
                map.put(key, newNode);
                len++;
            }
            else {
                map.remove(end.key); // LRU algo i.e. remove least recently used (which is at end of DLL)
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }
}

class DoubleLinkedListNode {
    public int val;
    public int key;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
    public DoubleLinkedListNode(int key, int value) {
        val = value;
        this.key = key;
    }
}