/****************************************Question***************************************
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-31
 * hint: binary indexed tree
 * @constructor
 * @param {number[]} nums
 **/
var NumArray = function(nums) {
    this.arr = nums.slice();
    this.sumArr = nums.slice();
    for(var i = 1; i < nums.length; i++){
        var k = i;
        while(k < nums.length){
            k = k + ( ( (k-1) ^ k ) & k ); 
            if( k < nums.length){
                this.sumArr[k] += nums[i];
            }
        }
    }
};

/**
 * @param {number} i
 * @param {number} val
 * @return {void}
 */
NumArray.prototype.update = function(i, val) {
    var diff = val - this.arr[i];
    this.arr[i] = val;
    if(i === 0){
        this.sumArr[i] += diff;
        return;
    }
    while(i < this.arr.length){
        this.sumArr[i] += diff;
        i = i + ( ( (i - 1) ^ i ) & i );
    }
    return;
};

/**
 * @param {number} i
 * @param {number} j
 * @return {number}
 */
NumArray.prototype.sumRange = function(i, j) {
    if(i == j){
        return this.arr[i];
    }
    
    var ret = 0;
    if(i === 0){
        ret += this.arr[i];
        i = 1;
    }
    var t = i;
    
    var sum1 = 0;
    while(j > 0){
        sum1 += this.sumArr[j];
        j = j - ( ( (j - 1) ^ j ) & j );
    }
    
    var sum2 = 0;
    while(i > 0){
        sum2 += this.sumArr[i];
        i = i - ( ( (i - 1) ^ i ) & i );
    }
    
    ret += sum1 - sum2 + this.arr[t]; 
    return ret;
};


/**
 * Your NumArray object will be instantiated and called as such:
 * var numArray = new NumArray(nums);
 * numArray.sumRange(0, 1);
 * numArray.update(1, 10);
 * numArray.sumRange(0, 2);
 */
