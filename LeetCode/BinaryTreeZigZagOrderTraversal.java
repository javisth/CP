/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
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
class BinaryTreeZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int trackLevel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>();
           // fill up a current level
            for(int i=0;i<size;i++){
                 TreeNode current = queue.remove();
                 currentLevel.add(current.val);
                 if(current.left!=null){
                     queue.add(current.left);
                 }
                 if(current.right!=null){
                     queue.add(current.right);
                }
            }
            //when adding current level into result, change
            if(trackLevel%2==0){
                result.add(currentLevel);
            }
            else{
                List<Integer> list2 = new ArrayList<Integer>();
                for(int i=currentLevel.size()-1;i>=0;i--){
                    list2.add(currentLevel.get(i));
                } 
                result.add(list2);
            }
            trackLevel++;
        }
        return result;
    }
}