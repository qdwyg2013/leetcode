//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 293 👎 0

package com.leetcode.editor.cn;

/**
 * java:[59]螺旋矩阵 II
 */
public class P59SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {

            // 循环的圈数，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理；n为偶数4，那么loop = 2 只是循环两圈
            int loop = n / 2;
            // 结果矩阵中每一个格的数值
            int count = 1;
            // 循环每一个圈的起始位置
            int startx = 0, starty = 0;
            // 每一圈循环，需要控制每一条边遍历的长度
            int offset = 1;
            // 矩阵中间的位置，例如：n为奇数3，中间的位置就是(1，1)；n为奇数5，中间位置为(2, 2)；n为偶数，则不存在中间位置
            int mid = n / 2;
            int i,j;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}