/* *************************************Question**************************************
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * ************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-18
 * */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        q.add(null);
        
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        
        int level = 1;
        
        while (!q.isEmpty()) {
            String str = q.poll();
        
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String word = new String(chars);
                        if (word.equals(end)){
                            return level + 1;
                        }
                        if (dict.contains(word) && !visited.contains(word)) {
                            q.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;
                if (!q.isEmpty()) { 
                    q.add(null);
                }
            }
        }
        return 0;
    }
}
