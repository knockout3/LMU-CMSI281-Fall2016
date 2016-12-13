import java.util.*;

public class Trie {
    char character;
    Trie[] children;
    boolean word;

    public Trie(){
        this.character = 0;
        this.children = new Trie[26];
        this.word = false;
    }

    public void add(String s) {
        if (s.isEmpty()) {
            this.word = true;
            return;
        }

        char letter = s.charAt(0);
        int index = letter - 'a';   //'a' value of 97, b = 98, 98-97 = 1

        if (this.children[index] == null) {
            this.children[index] = new Trie();
        }

        this.children[index].add(s.substring(1));
    }

    public boolean isWord(String s) {
        if (s.isEmpty()) {
            return this.word;
        }

        char letter = s.charAt(0)
        int index = letter - 'a';

        if (this.children == null) {
            return false;
        }

        return this.children[index].isWord(s.substring(1));
    }

}
