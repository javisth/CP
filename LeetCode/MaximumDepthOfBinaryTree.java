/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        int result=0;
        // need a variable to keep track of max depth
        int max=0;
        // check if our root is null
        if(root==null){
            return result;
        }
        // we build a queue to store our nodes
        Queue<TreeNode> queue=new LinkedList<>();
        // add our root
        queue.add(root);
        // traverse the tree and add nodes to queue
        while(!queue.isEmpty()){
            // increment result for current depth
            result++;
            // store size of queue
            int size=queue.size();
            // iterate through the current queue
            for(int i=0;i<size;i++){
                // get current treenode
                TreeNode current= queue.remove();

                if(current!=null){
                    // if current node has no children, its the maximum depth node
                    if(current.left==null && current.right==null){
                        max=result;
                    }
                    // if it has children we add them to the queue
                    else{
                        queue.add(current.left);
                        queue.add(current.right);
                    }
                }
                
            }
            // if our final depth is greater than max we get the max depth
            if(result>max){
                max=result;
            }
        }
        return max;
    }
}