/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
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
    public boolean isValidBST(TreeNode root) {
        // pass in root and min and max variable to track whether nodes are less than or equal to left and right children
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer max, Integer min){
        // if we have reached the end of the tree, return true
        if(root == null)
            return true;
        // if left node is greater than parent or right node is less than parent
        // return false
        if((max!=null && root.val >= max) || (min!=null && root.val <= min))
            return false;
        // we pass in left and right subtrees with what we need to calculate
        // we need to caluclate min for left subtree and maz for right subtree
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}