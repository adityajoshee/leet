package adityajoshee.hackerrank.ds;

import java.util.*;

/**
 * Created by aditya on 9/6/16.
 */
public class Trie {
    private Map<Character, Trie> map = new HashMap<>();

    //stores number of input string with prefix till this node.
    private int size=0;
    public Map<Character, Trie> getMap() {
        return map;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(String s) {
        char[] chars = s.toCharArray();
        boolean charExists = true;
        Trie tempTrie = this;
        int i = 0;
        while (charExists && i < chars.length) {
            if (tempTrie.getMap().containsKey(chars[i])) {
                tempTrie.setSize(tempTrie.getSize()+1);
                tempTrie = tempTrie.getMap().get(chars[i]);
                i++;
            }
            else {
                charExists = false;
            }
        }
        if (i == chars.length && tempTrie.getMap().containsKey('*')) {
            // do nothing...as the actual string exists.
        }
        if (i == chars.length) {
            tempTrie.getMap().put('*', null); // denotes end of valid string
        }
        else {
            // add the remaining chars
            while (i < chars.length) {
                tempTrie.setSize(tempTrie.getSize()+1);
                tempTrie.getMap().put(chars[i], new Trie());
                tempTrie = tempTrie.getMap().get(chars[i++]);
            }
            tempTrie.setSize(tempTrie.getSize()+1);
            tempTrie.getMap().put('*', null); // denotes end of valid string
        }
    }

    public int findPrefixCount(String prefix) {
        int i = 0;
        Trie current = this;
        char[] prefixChars = prefix.toCharArray();
        while (i < prefixChars.length) {
            if (current.getMap().containsKey(prefixChars[i])) {
                current = current.getMap().get(prefixChars[i]);
                i++;
            } else {
                break;
            }
        }
        if (i == prefixChars.length) {
            return current.getSize();
        }
        return 0;
    }

    private int getLeafCount(Trie t){
        int c = 0;
        Queue<Trie> tries = new LinkedList<>();
        tries.add(t);
        while(!tries.isEmpty()){
            Trie currentTrie = tries.poll();
            if(currentTrie!=null){
                Map<Character, Trie> currentMap = currentTrie.getMap();
                if(currentTrie!=null){
                    tries.addAll(currentMap.values());
                    if(currentMap.containsKey('*')){
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
