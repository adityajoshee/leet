package adityajoshee.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aditya on 10/15/16.
 */

// based on BFS of tree and maintaining level at every node
public class WordLadder {
    public static void main(String args[]){
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");
        System.out.println(findMinTrans("hit","cog",dict));
    }
    private static int findMinTrans(String start, String end, HashSet dict){
        //char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,start));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            String curr = node.word;
            if (curr.equals(end)){
                return node.level;
            }
            for (int k = 0; k < start.length(); k++) {
                for (char i = 'a'; i < 'z'; i++) {
                    if(curr.charAt(k)!=i){
                        char[] ns = curr.toCharArray();
                        ns[k] = i;
                        String u = new String(ns);
                        if (dict.contains(u)){
                            queue.add(new Node(node.level+1,u));
                        }
                    }
                }
            }
        }
        return -1;
    }
    static class Node{
        int level;
        String word;
        public Node(int level, String word){
            this.level = level;
            this.word = word;
        }
    }
}
