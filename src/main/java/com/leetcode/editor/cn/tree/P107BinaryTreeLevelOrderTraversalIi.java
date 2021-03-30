//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 423 👎 0

package com.leetcode.editor.cn.tree;

import com.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * java:[107]二叉树的层序遍历 II
 */
public class P107BinaryTreeLevelOrderTraversalIi {

    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            if (null == root) {
                return result;
            }

            // 方法：队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> currentLevelList = new ArrayList<>();
                // 这里一定要使用固定大小size，不要使用queue.size()，因为queue.size是不断变化的
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();
                    currentLevelList.add(node.val);

                    // 先左
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    // 后右
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
                // 每次从队首插入数组，这样就无需后面进行反转操作了
                result.add(0, currentLevelList);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}