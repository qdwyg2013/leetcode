//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 824 👎 0

package com.leetcode.editor.cn.tree;

import com.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * java:[102]二叉树的层序遍历
 */
public class P102BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<>();
            if (null == root) {
                return result;
            }

            // 方法：队列
            // 队列先进先出，符合一层一层遍历的逻辑；而栈先进后出，适合模拟深度优先遍历也就是递归的逻辑
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> currentLevelList = new ArrayList<>();
                int currentLevelSize = queue.size();
                // 这里一定要使用固定大小size，不要使用queue.size()，因为queue.size是不断变化的
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
                // 从队尾插入
                result.add(currentLevelList);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}