/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // error checking
        if(nums==null || nums.length==0)
            return null;
        // lets build tree recursively by passing in left pointer and right pointer to tree
        return buildTree(nums, 0, nums.length-1);
    }
    TreeNode buildTree(int[] nums, int left, int right){
        // base case when left crosses right
        if(left > right)
            return null;
        // since its binary search tree in sorted array, set root to middle element
        int middle = left + (right-left)/2;
        TreeNode current = new TreeNode(nums[middle]);
        // store left and right child recursively
        // get left child from left half of tree
        current.left = buildTree(nums, left, middle-1);
        // get right child from right half of tree
        current.right = buildTree(nums, middle+1, right);
        // return current node
        return current;
    }

}