/* *****************************************Question********************************************
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * **********************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-17
 * */
public class Solution {
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> paths;
        dict.add(end);
        List<String> tovisit = new ArrayList<>();
        tovisit.add(start);
        List<Integer> levels = new ArrayList<>();
        levels.add(0);
        Set<String> visited = new HashSet<>();
        Map<String,Map<Integer,Set<String>>> prevs = new HashMap<>();
        prevs.put(start, new HashMap<>());
        int maxLen = Integer.MAX_VALUE;
        while(tovisit.size() > 0) {
            String current = tovisit.remove(0);
            visited.add(current);
            int level = levels.remove(0);
            if(level > maxLen) break;
            if(current.equals(end) && level<maxLen) maxLen=level;
            else {
                for(String s: possMoves(current, end, dict, visited)) {
                    if(!tovisit.contains(s)) {
                        tovisit.add(s);
                        levels.add(level+1);
                    }
                    if(!prevs.containsKey(s)) {
                        Map<Integer,Set<String>> levelprevs = new HashMap<>();
                        Set<String> prevset = new HashSet<>();
                        levelprevs.put(level, prevset);
                        prevs.put(s, levelprevs);
                    }
                    if(prevs.get(s).containsKey(level)) {
                        prevs.get(s).get(level).add(current);
                    }
                }
            }
        }
        paths = buildPaths(start,end,prevs);
        return paths;
    }
    
    public static List<List<String>> buildPaths(String start, String end, Map<String,Map<Integer,Set<String>>> prevs) {
        List<List<String>> paths = new ArrayList<>();
        Set<String> prevsteps = null;
        if(prevs.containsKey(end)) {
            for(int i:prevs.get(end).keySet()) 
                prevsteps = prevs.get(end).get(i);
        }
        if(prevsteps==null) {
            if(start.equals(end)) {
                List<String> path = new ArrayList<>();
                path.add(end);
                paths.add(path);
            }
            return paths;
        }
        if(prevsteps.isEmpty()) {
            List<String> path = new ArrayList<>();
            path.add(end);
            paths.add(path);
        } else {
            for(String s: prevsteps) {
                for(List<String> path: buildPaths(start,s,prevs)) {
                    path.add(end);
                    paths.add(path);
                }
            }
        }
        return paths;
    }
    
    public static List<String> possMoves(String word, String end, Set<String> dict, Set<String> visited) {
        List<String> moves = new ArrayList<>();
        for(int i=0;i < word.length();i++) {
            char[] chars = word.toCharArray();
            for(char c = 'a';c <= 'z';c++) {
                chars[i] = c;
                String next = new String(chars);
                if(dict.contains(next) && !visited.contains(next)){
                    moves.add(next);
                }
            }
        }
        if(moves.contains(end)) {
            moves = new ArrayList<>();
            moves.add(end);
        }
        return moves;
    }
}
