package hackerrank.ds.problems.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * Created by aditya on 9/6/16.
 */
//https://www.hackerrank.com/challenges/contacts
public class Contacts {
    public static void main(String args[]) throws IOException{
        long start = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int q = Integer.parseInt( br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < q; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("add")){
                addContact(input[1], trie);
            }
            else{
                System.out.println(findContact(input[1], trie));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    private static void addContact(String name, Trie trie){
        trie.add(name);
    }
    private static int findContact(String prefix, Trie trie){
        return trie.find(prefix);
    }



/**
 * Created by aditya on 9/6/16.
 */
     static class Trie {
        private Map<Character, Trie> map = new HashMap<>();
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

        public int find(String prefix) {
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
}
