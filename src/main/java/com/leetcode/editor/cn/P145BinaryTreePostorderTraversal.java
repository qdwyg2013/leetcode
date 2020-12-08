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
            inorders(root, result);
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