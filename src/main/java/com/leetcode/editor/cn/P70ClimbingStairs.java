//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// 输入： 4
//输出： 4
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶 + 1 阶
//2.  2 阶 + 2 阶
//3.  2 阶 + 1 阶 + 1 阶
//4.  1 阶 + 2 阶 + 1 阶
//5.  1 阶 + 1 阶 + 2 阶
//
// Related Topics 动态规划 
// 👍 1216 👎 0

package com.leetcode.editor.cn;

/**
 * java:[70]爬楼梯
 */
public class P70ClimbingStairs {

    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
        System.out.println(solution.iteration(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            // 斐波那契数列 f(n) = f(n-1) + f(n-2)
            if (n < 3) {
                return n;
            }
            int f1 = 1, f2 = 2, f3 = 0;
            // n 仅用于记录计算到第几阶楼梯了，循环内部的逻辑与 n 无关
            for (int i = 3; i <= n; i++) {
                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }

            return f3;

        }

        /**
         * 迭代的方式
         */
        private int iteration(int n) {
            System.out.println("--------" + n);
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int result = iteration(n - 1) + iteration(n - 2);
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}