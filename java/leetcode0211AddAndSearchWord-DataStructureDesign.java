/* ********************************Question***************************************
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
 * A . means it can represent any one letter.
 * For example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * *******************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-29
 * */
public class WordDictionary {

    private class TrieNode {
        // Initialize your data structure here.
        public Map<Character, TrieNode> mp;
        public boolean end;
        public TrieNode() {
            mp = new HashMap<>();
            end = false;
        }
    }
    private TrieNode root = new TrieNode();
    
    
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return mysearch(word, root);
    }
    private boolean mysearch(String word, TrieNode root){
        int len = word.length();
        int start = 0;
        TrieNode tn = root;
        boolean result = false;
        while(start < len){
            char ch = word.charAt(start);
            if(ch != '.'){
                if(!tn.mp.containsKey(ch)){
                    return false;
                }else{
                    tn = tn.mp.get(ch);
                    start++;
                }
            }else{
                for(int i = 0; i < 26; i++){
                    char temp = (char)('a'+i);
                    if(tn.mp.containsKey(temp)){
                        result = result || mysearch(word.substring(start+1), tn.mp.get(temp));
                    }
                    if(result){
                        return true;
                    }
                }
                return result;
            }
        }
        return tn.end;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
