/***************************************Question***************************************
 * For a undirected graph with tree characteristics, we can choose any node as the root. 
 * The result graph is then a rooted tree. Among all possible rooted trees, 
 * those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * 
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. 
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * return [1]
 * 
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 * return [3, 4]
 * 
 * Hint:
 * How many MHTs can a graph have at most?
 * 
 * Note:
 * (1) According to the definition of tree on Wikipedia: 
 * “a tree is an undirected graph in which any two vertices are connected by exactly one path. 
 * In other words, any connected graph without simple cycles is a tree.”
 * 
 * (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-06
 * @param {Number} start 起始点，
 * @param {Array} tree 各个Node所链接的其他Node
 * 				  eg. [[1,2],[3,4]] => 0链接1、2；1链接3、4
 * @param {Array} preNode 各个Node的前一个Node是谁
 **/
var bfs = function(start, tree, preNode) {
    var num = preNode.length;
    preNode[start] = -1;
    var depth = []; //每个节点在树中的深度
    var visited = []; //每个节点是否已经被访问过
    var queue = []; //
    for(var i = 0; i < num; i++){
        visited.push(false);
        depth.push(-1);
    }
    depth[start] = 0;
    visited[start] = true;
    queue.push(start);
    
    while(queue.length > 0){
        var elem = queue.shift();
        for(var t in tree[elem]){
            var val = tree[elem][t];
            if(!visited[val]){
                visited[val] = true;
                depth[val] = depth[elem] + 1;
                preNode[val] = elem;
                queue.push(val);
            }
        }
    }
    return depth;
};

/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function(n, edges) {
    var tree = [];
    var preNode = [];
    var i; //loop iterator
    for(i = 0; i < n; i++){
    	tree.push([]);
    	preNode.push(-1);
    }
    for(var j = 0; j < edges.length; j++) {
    	tree[edges[j][0]].push(edges[j][1]);
    	tree[edges[j][1]].push(edges[j][0]);
    }
    var depth1 = bfs(0, tree, preNode);
    var maxDepPoint = -1;
    var maxDepth = -1;
    for(i = 0; i < depth1.length; i++){
    	if(depth1[i] > maxDepth){
    		maxDepth = depth1[i];
    		maxDepPoint = i;
    	}
    }
    
    var depth2 = bfs(maxDepPoint, tree, preNode);
    maxDepth = -1;
    maxDepPoint = -1;
    for(i = 0; i < depth2.length; i++){
    	if(depth2[i] > maxDepth){
    		maxDepth = depth2[i];
    		maxDepPoint = i;
    	}
    }
    
    var result = [maxDepPoint];
    var temp = preNode[maxDepPoint];
    while(temp > -1){
    	result.push(temp);
    	temp = preNode[temp];
    }
    if(result.length & 0x1 === 1){
    	return [ result[(result.length-1)/2] ];
    }
    return [ result[result.length/2], result[result.length/2-1] ];
};
