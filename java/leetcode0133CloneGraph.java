/* **********************************Question**************************************
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * *********************************************************************************/

/* *
 * @author Horst Xu
 * @date 2015-09-28
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        Stack<UndirectedGraphNode> st = new Stack<>();
        st.push(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> mp = new HashMap<>();
        mp.put(node, new UndirectedGraphNode(node.label));
        
        while (!st.isEmpty()) {
            UndirectedGraphNode temp = st.pop();
            for(UndirectedGraphNode nb : temp.neighbors){
                if (!mp.containsKey(nb)) {
                    mp.put(nb, new UndirectedGraphNode(nb.label));
                    st.push(nb);
                }
                mp.get(temp).neighbors.add(mp.get(nb));
            }
        }
        return mp.get(node);
    }
}
