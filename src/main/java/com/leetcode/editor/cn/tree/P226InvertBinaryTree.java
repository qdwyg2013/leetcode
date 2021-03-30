//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 803 👎 0

package com.leetcode.editor.cn.tree;

import com.leetcode.editor.cn.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java:[226]翻转二叉树
 */
public class P226InvertBinaryTree {

    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
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
        public TreeNode invertTree(TreeNode root) {

            // 方法一：递归
//            if (null == root) {
//                return null;
//            }
//            // 将当前节点的左右子树交换
//            TreeNode temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//
//            // 递归交换当前节点的 左子树
//            invertTree(root.left);
//            // 递归交换当前节点的 右子树
//            invertTree(root.right);
//
//            return root;

            // 方法二：迭代——前序遍历
//            // 入栈：根 + 右 + 左 （根提前处理）
//            // 出栈：根 - 左 - 右
//            if (null == root) {
//                return null;
//            }
//
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//            while (!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//
//                // 将当前节点的左右子树交换
//                TreeNode temp = node.left;
//                node.left = node.right;
//                node.right = temp;
//
//                if (null != node.right) {
//                    stack.push(node.right);
//                }
//                if (null != node.left) {
//                    stack.push(node.left);
//                }
//            }
//            return root;

            // 方法三：迭代——层次遍历
            if (null == root) {
                return null;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                for (int i = 0; i < currentLevelSize; i++) {
                    TreeNode node = queue.poll();

                    // 将当前节点的左右子树交换
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;

                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}