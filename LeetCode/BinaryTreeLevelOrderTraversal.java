/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // First define the desired return type 
        List<List<Integer>> result = new ArrayList<>();
        // error check: check if the input is empty
        if(root == null){
            return result;
        }
        // make a queue of treeNode's to store each tree node
        Queue<TreeNode> queue = new LinkedList<>();
        // add the first element to the queue
        queue.add(root);
        // loop to traverse the queue while empty
        while(!queue.isEmpty()){
            // keep updating size of the queue
            int size = queue.size();
            // make a list to store values of each level
            List<Integer> currentLevel = new ArrayList<Integer>();
            // traverse each level added to the queue
            for(int i=0;i<size;i++){
                // store and release the current queue element
                TreeNode current = queue.remove();
                // add that element to our current level list
                currentLevel.add(current.val);
                // if the element has any children add them too
                // check for a left child
                if(current.left!=null){
                    queue.add(current.left);
                }
                // check for a right side
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            // add the extracted current level list to our result as an element
            result.add(currentLevel);
        }
        // return our resulting list
        return result;
    }
}