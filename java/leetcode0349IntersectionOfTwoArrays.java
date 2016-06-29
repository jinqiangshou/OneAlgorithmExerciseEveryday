/******************************Question**********************************
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 ************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-06-29
 **/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(!hs.contains(nums1[i]))
            {
                hs.add(nums1[i]);
            }
        }
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums2.length; i++)
        {
            if(hs.contains(nums2[i]))
            {
                hs.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}
