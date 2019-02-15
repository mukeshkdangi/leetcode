/**
https://leetcode.com/problems/binary-tree-inorder-traversal/
Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         return traverse(root, list);
        
    }
    
    private List<Integer>  traverse(TreeNode root,  List<Integer> list)
    {
         if(root ==null) return list;
        
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
        
        return list;
    }
}
