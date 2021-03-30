//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 436 👎 0

package com.leetcode.editor.cn.tree;

import com.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * java:[199]二叉树的右视图
 */
public class P199BinaryTreeRightSideView {

    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {

            // 方法：队列
            List<Integer> result = new ArrayList<>();
            if (null == root) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();

                    // 将每一层的最后元素放入result数组中
                    if (i == (currentLevelSize - 1)) {
                        result.add(node.val);
                    }

                    // 先左
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    // 后右
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}