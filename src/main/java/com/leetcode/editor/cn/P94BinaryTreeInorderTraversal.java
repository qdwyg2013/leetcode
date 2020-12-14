//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 759 👎 0

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * java:[94]二叉树的中序遍历
 */
public class P94BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (null == root) {
                return result;
            }

            // 方法一：递归
//            inorders(root, result);

            // 方法二：迭代 —— 栈
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                // 找到最左节点 放入栈中
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }

                TreeNode node = stack.pop();
                // 存入结果集
                result.add(node.val);

                // 找到当前节点的右节点
                if (null != node.right) {
                    curr = node.right;
                }
            }


            return result;
        }

        public void inorders(TreeNode root, List<Integer> result) {
            // root节点为null，则结束迭代
            if (null == root) {
                return;
            }

            // 中序遍历：左-根-右
            // 遍历左节点
            inorders(root.left, result);
            // 左节点为null时，将根root节点值添加到result集合中
            result.add(root.val);
            // 遍历右节点
            inorders(root.right, result);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}