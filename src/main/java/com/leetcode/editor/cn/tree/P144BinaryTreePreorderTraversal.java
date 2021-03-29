//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 472 👎 0

package com.leetcode.editor.cn.tree;


import com.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * java:[144]二叉树的前序遍历
 */
public class P144BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            // 方法一：递归
//            traversal(root, result);

            // 方法二：迭代 - 栈
            if (null == root) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            // 入栈：根 + 右 - 左 （根提前处理）
            // 出栈：根 + 左 - 右
            // 根节点入栈
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                // 存入结果集
                result.add(node.val);

                // 右节点先入栈——先进后出
                if (null != node.right) {
                    stack.push(node.right);
                }

                // 左节点后入栈——后进先出。所以先pop出左节点
                if (null != node.left) {
                    stack.push(node.left);
                }
            }

            return result;
        }

        private void traversal(TreeNode root, List<Integer> result) {

            // recursion termination
            if (null == root) {
                return;
            }

            // 前序遍历：根-左-右
            // process logic in current level
            result.add(root.val);

            // drill down
            traversal(root.left, result);
            traversal(root.right, result);

            // reverse the current level status if needed

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}