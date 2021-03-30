//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 247 👎 0

package com.leetcode.editor.cn.tree;

import com.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * java:[637]二叉树的层平均值
 */
public class P637AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        Solution solution = new P637AverageOfLevelsInBinaryTree().new Solution();
        // TO TEST
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        // 方法：队列
        List<Double> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double currentLevelSum = 0D;
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                currentLevelSum += node.val;

                // 先左
                if (null != node.left) {
                    queue.offer(node.left);
                }
                // 后右
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }

            // 将每一层均值放进结果集
            result.add(currentLevelSum / currentLevelSize);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}