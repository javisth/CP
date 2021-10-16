/*
Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

 

Example 1:


Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
Explanation: 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
Example 2:


Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]
Example 3:


Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        // calls a helper function to check if subtrees contain a 1
        // if the root contains 1, return the root
        if(containsOne(root))
            return root;
        else
            return null;       
    }
    public boolean containsOne(TreeNode root){
        // if the node is empty, return false
        if(root==null)
            return false;
        // check if the left subtree contains 1
        boolean leftChild = containsOne(root.left);
        // check if the right subtree contains 1
        boolean rightChild = containsOne(root.right);
        // if the left subtree doesnt contain 1, set it to null
        if(!leftChild)
            root.left = null;
        // if the right subtree doesnt contain 1, set it to null
        if(!rightChild)
            root.right = null;
        // check whether the current node, left child or right child are 1
        return root.val == 1 || leftChild || rightChild;
    }
}