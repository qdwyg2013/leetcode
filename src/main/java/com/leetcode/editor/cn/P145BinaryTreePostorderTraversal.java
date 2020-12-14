//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 486 👎 0

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java:[145]二叉树的后序遍历
 */
public class P145BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (null == root) {
                return result;
            }

            // 方法一：递归
//            inorders(root, result);

            // 方法二：迭代 - 栈
            /*
                前序遍历：根-左-右
                入栈时 根 + 右 - 左；出栈 根 + 左 - 右 （根提前处理）

                后序遍历：左-右-根
                入栈时 根 + 左 - 右；出栈 右 - 左 - 根 （根不提前处理）
             */

            Stack<TreeNode> stack1 = new Stack<>();
            stack1.push(root);

            Stack<TreeNode> stack2 = new Stack<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();

                // 入结果栈。根 + 左 - 右
                stack2.push(node);

                // 左 入栈
                if (null != node.left) {
                    stack1.push(node.left);
                }
                // 右 入栈
                if (null != node.right) {
                    stack1.push(node.right);
                }
            }

            // 结果栈数据反转
            while (!stack2.isEmpty()) {
                result.add(stack2.pop().val);
            }

            return result;
        }

        private void inorders(TreeNode root, List<Integer> result) {

            // recursion termination
            if (null == root) {
                return;
            }

            // 后序遍历：左-右-根
            // process login in current level

            // drill down
            inorders(root.left, result);
            inorders(root.right, result);

            result.add(root.val);

            // reverse the current level status if needed

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}