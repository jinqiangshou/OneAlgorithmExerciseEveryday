/* *************************************Question***************************************
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * ************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-03
 * */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            if (!visited.add(s.substring(i - 10, i))) {
                res.add(s.substring(i - 10, i));
            }
        }
        return new ArrayList<>(res);
    }
}
