/**
 * @author Horst Xu
 * @date 2016-05-26
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * function NestedInteger() {
 *
 *     Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     @return {boolean}
 *     this.isInteger = function() {
 *         ...
 *     };
 *
 *     Return the single integer that this NestedInteger holds, if it holds a single integer
 *     Return null if this NestedInteger holds a nested list
 *     @return {integer}
 *     this.getInteger = function() {
 *         ...
 *     };
 *
 *     Return the nested list that this NestedInteger holds, if it holds a nested list
 *     Return null if this NestedInteger holds a single integer
 *     @return {NestedInteger[]}
 *     this.getList = function() {
 *         ...
 *     };
 * };
 */
/**
 * @constructor
 * @param {NestedInteger[]} nestedList
 */
var NestedIterator = function(nestedList) {
    this.result = [];
    this.ptr = 0;
    var constructResult = function(nestedList) {
        for(var i = 0; i < nestedList.length; i++) {
            if(nestedList[i].isInteger()) {
                this.result.push(nestedList[i].getInteger());
            } else {
                constructResult.call(this, nestedList[i].getList());
            }
        }
    };
    constructResult.call(this, nestedList);
};


/**
 * @this NestedIterator
 * @returns {boolean}
 */
NestedIterator.prototype.hasNext = function() {
    if(typeof this.result[this.ptr] !== 'undefined') {
        return true;
    }
    return false;
};

/**
 * @this NestedIterator
 * @returns {integer}
 */
NestedIterator.prototype.next = function() {
    this.ptr ++;
    return this.result[this.ptr-1];
};

/**
 * Your NestedIterator will be called like this:
 * var i = new NestedIterator(nestedList), a = [];
 * while (i.hasNext()) a.push(i.next());
*/
