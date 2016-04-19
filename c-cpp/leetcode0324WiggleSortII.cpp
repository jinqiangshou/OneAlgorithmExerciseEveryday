/**
 * @author Horst Xu
 * @date 2016-04-19
 * @desc I didn't find out an O(n) time and O(1) space solution.
 *       The nice solution below is from others.
 * The esoteric code #define A(i) nums[(1+2*(i)) % (n|1)] can be explained by
 * (Assuming nums.length = 10)
 * Accessing A(0) actually accesses nums[1].
 * Accessing A(1) actually accesses nums[3].
 * Accessing A(2) actually accesses nums[5].
 * Accessing A(3) actually accesses nums[7].
 * Accessing A(4) actually accesses nums[9].
 * Accessing A(5) actually accesses nums[0].
 * Accessing A(6) actually accesses nums[2].
 * Accessing A(7) actually accesses nums[4].
 * Accessing A(8) actually accesses nums[6].
 * Accessing A(9) actually accesses nums[8].
 **/
class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        int n = nums.size();
        
        // Find a median.
        auto midptr = nums.begin() + n / 2;
        nth_element(nums.begin(), midptr, nums.end());
        int mid = *midptr;
        
        // Index-rewiring.
        #define A(i) nums[(1+2*(i)) % (n|1)]
        
        // 3-way-partition-to-wiggly in O(n) time with O(1) space.
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (A(j) > mid)
                swap(A(i++), A(j++));
            else if (A(j) < mid)
                swap(A(j), A(k--));
            else
                j++;
        }
    }
};
