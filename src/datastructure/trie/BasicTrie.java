package datastructure.trie;

import java.util.*;

/**
 * Created by adityajoshee on 09/05/16.
 */
public class BasicTrie {


    public static void main (String args[]){
        BasicTrie trie = new BasicTrie();
        trie.insert("aditya");
        trie.insert("adi");
        trie.insert("a");
        trie.insert("josh");
        trie.insert("joshee");

        trie.insert("");
        System.out.println(trie.search("aditya"));
        System.out.println(trie.search("adi"));
        System.out.println(trie.search("a"));
        System.out.println(trie.search("adit"));
        System.out.println(trie.search("josh"));
        System.out.println(trie.search("joshee"));


        System.out.println(trie.getWordsWithPrefix("ad"));
    }



    private Map<Character,BasicTrie> trieMap; // Map of a map
    private boolean isValid;

    public BasicTrie(){
        this.trieMap=new HashMap<>();
    }

    public void insert(String input){
        if(input!=null) {
            if (input.length() == 0) {
                this.isValid = true;
                return;
            }

            Map<Character,BasicTrie> children = this.trieMap;
            BasicTrie b = new BasicTrie();

            for(int i=0; i<input.length(); i++){
                Character c = input.charAt(i);
                if(!children.containsKey(c))
                {
                    b = new BasicTrie();
                    children.put(c,b);
                }
                else
                {
                    b = children.get(c);
                }
                children = b.getTrieMap();
            }
            b.setIsValid(true);

        }

    }

    public boolean search(String input){
        if(input==null){
            return false;
        }
        if(input.length()==0){
            return this.isValid;
        }
        Map<Character,BasicTrie> tnode = this.trieMap;
        boolean isCurrentPathValidWord=false;
        for(int i=0;i<input.length();i++){
            Character c = input.charAt(i);
            System.out.print(c+" ");
            if(tnode.containsKey(c)){
                isCurrentPathValidWord = tnode.get(c).isValid();
                tnode=tnode.get(c).getTrieMap();
            }
            else{
                return false;
            }
        }
        return isCurrentPathValidWord;
    }


    public Set<String> getWordsWithPrefix(String input){
        Set<String> output = new HashSet<>();
        if(input==null){
            return output;
        }
        if(input.length()==0){
            return output;            //assuming blanks are not prefixes
        }
        Map<Character,BasicTrie> tmap = this.trieMap;
        BasicTrie tnode = new BasicTrie();
        // Search whole prefix
        for(int i=0;i<input.length();i++){
            Character c = input.charAt(i);
            System.out.print(c+" ");
            //System.out.println(tmap.get(c));

            if(tmap.containsKey(c)){
                tnode = tmap.get(c);
                tmap=tnode.getTrieMap();
            }
            else{
                return output;
            }
        }

        // prefix found.
        if(tnode.isValid){
            output.add(input);
        }

        getAllWords(input,tnode,output,null);
        return output;
    }

    //TBD
    public Set<String> getAllWords(String prefix,BasicTrie trieNode,Set<String> op,Character x){
        Map<Character,BasicTrie> map = trieNode.getTrieMap();
        Set<Character> charset = map.keySet();
        if(trieNode.isValid && x!=null)
            op.add(prefix+x);
        for(Character c: charset){
            getAllWords(prefix, trieNode.getTrieMap().get(c),op,c);
        }
        return op;
    }



    public Map<Character, BasicTrie> getTrieMap() {
        return trieMap;
    }

    public void setNode(Map<Character, BasicTrie> trieMap) {
        this.trieMap = trieMap;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}
