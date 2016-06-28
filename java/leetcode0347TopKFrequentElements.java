/********************************Question************************************
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 ****************************************************************************/
 
/**
 * @author Horst Xu
 * @date 2016-06-28
 **/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0; i < nums.length; i++)
        {
            if(hm.containsKey(nums[i]))
            {
                int temp = hm.get(nums[i]);
                hm.put(nums[i], temp+1);
            } else {
                hm.put(nums[i], 1);
            }
        }
        
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        
        for(Integer key : hm.keySet())
        {
            int val = hm.get(key);
            if(bucket[val] == null)
            {
                bucket[val] = new ArrayList();
            }
            bucket[val].add(key);
        }
        
        List<Integer> result = new LinkedList();
        
        for(int i = nums.length; i >= 0; i-- )
        {
            if(bucket[i] != null && !bucket[i].isEmpty())
            {
                for(int j = 0; j < bucket[i].size(); j++)
                {
                    result.add(bucket[i].get(j));
                    if(result.size() >= k)
                    {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
