/***********************************Question*************************************
 * You are given an integer array nums and you have to return a new counts array. 
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-11
 **/
var treeNode = function(val) {
    this.left = null;
    this.right = null;
    this.value = val;
    this.howManyLeft = 0;
    this.dup = 1;
};

var tree = function(){
    this.root = null;
};

tree.prototype.addElement = function(value, result) {
    if(this.root === null) {
        result.push(0);
        this.root = new treeNode(value);
        return;
    }
    var current = this.root;
    var parent = current;
    var count = 0;
    while(current !== null) {
        parent = current;
        if(value < current.value) {
            current.howManyLeft ++;
            current = current.left;
            continue;
        }
        if(value === current.value) {
            result.push(count + current.howManyLeft);
            current.dup++;
            return;
        }
        if(value > current.value) {
            count += (current.howManyLeft + current.dup);
            current = current.right;
            continue;
        }
    }
    if(value < parent.value) {
        parent.left = new treeNode(value);
    } else if(value > parent.value) {
        parent.right = new treeNode(value);
    }
    result.push(count);
};

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var countSmaller = function(nums) {
    var bstree = new tree();
    var result = [];
    for(var i = nums.length-1; i >= 0; i--) {
        bstree.addElement(nums[i],result);
    }
    
    return result.reverse();
};
