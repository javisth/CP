/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 

Example 1:


Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [0]
Output: [0]
Example 4:

Input: head = [1,3]
Output: [3,1]
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        // error check
        if(head == null)
            return null;
        // convert list to array for easy access of elements
        // first lets find size of list
        int size = 0;
        ListNode copy = head;
        while(copy!=null){
            copy = copy.next;
            size++;
        }
        int arr[] = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = head.val;
            head = head.next;
        }
        // build BST recursively by passing in left and right pointers
        return buildTree(arr, 0, size-1);
    }
    TreeNode buildTree(int arr[], int left, int right){
        // base case to check if left crosses right
        if(left>right)
            return null;
        // store middle element of array as root since BST
        int middle = left+(right-left)/2;
        TreeNode current = new TreeNode(arr[middle]);
        // find left and right children of tree recursively
        current.left = buildTree(arr, left, middle-1);
        current.right = buildTree(arr, middle+1, right);
        return current;
    }
}