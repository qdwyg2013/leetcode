//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 852 👎 0

package com.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * java:[98]验证二叉搜索树
 */
public class P98ValidateBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
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

        public boolean isValidBST(TreeNode root) {

            // 方法一：中序遍历。 先中序遍历后获得结果集，再查看是否为升序
            List<Integer> list = new LinkedList<>();
            inorders(root, list);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) >= list.get(i)) {
                    return false;
                }
            }

            return true;
        }

        private void inorders(TreeNode root, List<Integer> list) {

            if (null == root) {
                return;
            }

            // 中序遍历
            inorders(root.left, list);
            list.add(root.val);
            inorders(root.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}