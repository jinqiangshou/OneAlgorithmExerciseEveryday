/* *************************************Question******************************************
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * ***************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-23
 * */
class TrieNode {
    // Initialize your data structure here.
    public Map<Character, TrieNode> mp;
    public boolean end;
    public TrieNode() {
        mp = new HashMap<>();
        end = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int len = word.length();
        if(len < 1){
            root.end = true;
            return;
        }
        TrieNode tn = root;
        int start = 0;
        while(start < len){
            char ch = word.charAt(start);
            if(tn.mp.containsKey(ch)){
                tn = tn.mp.get(ch);
            }else{
                TrieNode temp = new TrieNode();
                tn.mp.put(ch, temp);
                tn = temp;
            }
            start++;
        }
        tn.end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int len = word.length();
        int start = 0;
        TrieNode tn = root;
        while(start < len){
            char ch = word.charAt(start);
            if(!tn.mp.containsKey(ch)){
                return false;
            }else{
                tn = tn.mp.get(ch);
                start++;
            }
        }
        return tn.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        if(len == 0){
            return true;
        }
        int start = 0;
        TrieNode tn = root;
        while(start < len){
            char ch = prefix.charAt(start);
            if(!tn.mp.containsKey(ch)){
                return false;
            }else{
                tn = tn.mp.get(ch);
                start++;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
