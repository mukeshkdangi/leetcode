/**
103. Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    
    List<List<Integer>>  zigZagList = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root==null) return zigZagList;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(root);
    
        while(!stack1.empty() ||  !stack2.empty())
        {
              List<Integer> zigZagList1 = new ArrayList<>();
            while(!stack1.empty())
            {
                
                TreeNode temp  = stack1.peek();
                stack1.pop();
                zigZagList1.add(temp.val);
                
                if(temp.left!=null) stack2.push(temp.left);
                if(temp.right!=null) stack2.push(temp.right);
                
            }
            if(zigZagList1.size()>0)
            zigZagList.add(zigZagList1);
            
            
            
            
        List<Integer> zigZagList2 = new ArrayList<>();
            while(!stack2.empty())
            {
                
                TreeNode temp  = stack2.pop();
                zigZagList2.add(temp.val);
                
                if(temp.right!=null) stack1.push(temp.right);
                if(temp.left!=null) stack1.push(temp.left);
                
            }
            if(zigZagList2.size()>0)
            zigZagList.add(zigZagList2);
            
        }
        return zigZagList;
    }
}