/***************************************Question********************************************
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * 1. What if the given array is already sorted? How would you optimize your algorithm?
 * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * 3. What if elements of nums2 are stored on disk, and the memory is limited 
 *    such that you cannot load all elements into the memory at once?
 *******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-07-04
 **/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0; i < nums1.length; i++)
        {
            if(!hm.containsKey(nums1[i]))
            {
                hm.put(nums1[i], 1);
            }else{
                hm.put(nums1[i], hm.get(nums1[i])+1);
            }
        }
        
        List<Integer> list = new LinkedList();
        for(int i = 0; i < nums2.length; i++)
        {
            if(hm.containsKey(nums2[i]))
            {
                int temp = hm.get(nums2[i]);
                if(temp == 1)
                {
                    hm.remove(nums2[i]);
                }else{
                    hm.put(nums2[i], temp-1);
                }
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
