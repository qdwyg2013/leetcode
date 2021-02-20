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

package com.leetcode.editor.cn.array;

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

            // 方法：循环不变量原则
            /*
                模拟顺时针画矩阵的过程:
                    填充上行从左到右
                    填充右列从上到下
                    填充下行从右到左
                    填充左列从下到上
                由外向内一圈一圈这么画下去。
                坚持了每条边左闭右开的原则
             */
            int[][] res = new int[n][n];
            // 定义每循环一个圈的起始位置
            int startx = 0, starty = 0;
            // 循环的圈数，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理；n为偶数4，那么loop = 2 只是循环两圈
            int loop = n / 2;
            // 矩阵中间的位置，例如：n为奇数3，中间的位置就是(1，1)；n为奇数5，中间位置为(2, 2)；n为偶数，则不存在中间位置
            int mid = n / 2;
            // 用来给矩阵中每一个空格赋值(1 2 3 4 5 ...)
            int count = 1;
            // 每一圈循环，需要控制每一条边遍历的长度。因为是 左闭右开，所以初始值为 1
            int offset = 1;
            // 循环时移动的坐标
            int i, j;

            while (loop > 0) {
                // 循环的圈数
                loop--;

                // 用于标记循环时移动的坐标
                i = startx;
                j = starty;

                // 下面开始的四个for就是模拟转了一圈
                // 模拟填充上行 从左到右(左闭右开)
                for (; j < starty + n - offset; j++) {
                    res[i][j] = count;
                    count++;
                }
                // 模拟填充右列 从上到下(左闭右开)
                for (; i < startx + n - offset; i++) {
                    res[i][j] = count;
                    count++;
                }
                // 模拟填充下行 从右到左(左闭右开)
                for (; j > starty; j--) {
                    res[i][j] = count;
                    count++;
                }
                // 模拟填充左列 从下到上(左闭右开)
                for (; i > startx; i--) {
                    res[i][j] = count;
                    count++;
                }

                // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
                startx++;
                starty++;

                // offset 控制每一圈里每一条边遍历的长度。因为每遍历完一圈后，下一圈长度会减2(左右各1)，所以加2
                offset += 2;
            }

            // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
            if (n % 2 > 0) {
                res[mid][mid] = count;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}