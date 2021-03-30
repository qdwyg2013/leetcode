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

package com.leetcode.editor.cn.dynamic;

/**
 * java:[70]爬楼梯
 */
public class P70ClimbingStairs {

    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            // 方法：斐波那契数列 f(n) = f(n-1) + f(n-2)
            if (n <= 1) {
                return n;
            }

            // 1.确定dp数组以及下标的含义
            int[] dp = new int[3];
            // 3.dp数组初始化——因为dp[0]为零级台阶，没有任何意义，所以此处从一级台阶dp[1]开始
            dp[1] = 1;
            dp[2] = 2;
            // 4.确定遍历顺序——从前往后。dp[3] = dp[2] + dp[1]，所以 i 从3开始遍历
            for (int i = 3; i <= n; i++) {
                // 2.确定递推公式
                int sum = dp[1] + dp[2];
                dp[1] = dp[2];
                dp[2] = sum;
            }

            return dp[2];

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}