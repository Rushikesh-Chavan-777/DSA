import java.util.*;

public class Tries {
    static class Node{
        Node[] children;
        boolean eow;
        Node() {
            children = new Node[26];
            for(int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root  = new Node();
    public static void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                //new node
                curr.children[idx] = new Node();
            }
            if(i == word.length() -1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }
    public static boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            if(i == (word.length() - 1) && curr.children[idx].eow == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"the","thee", "a", "their", "there", "any"};
        for(int j = 0; j < words.length; j++) {
            insert(words[j]);
        }
        System.out.println(search("thi"));

    }
}
