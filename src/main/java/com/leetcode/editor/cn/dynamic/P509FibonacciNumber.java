//斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 数组 
// 👍 260 👎 0

package com.leetcode.editor.cn.dynamic;

/**
 * java:[509]斐波那契数
 */
public class P509FibonacciNumber {

    public static void main(String[] args) {
        Solution solution = new P509FibonacciNumber().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {

            /*
                1.确定dp数组以及下标的含义
                dp[i]的定义为：第i个数的斐波那契数值是dp[i]

                2.确定递推公式
                题目已经把递推公式直接给我们了：dp[i] = dp[i - 1] + dp[i - 2];

                3.dp数组如何初始化
                题目中把如何初始化也直接给我们了，如下：
                    dp[0] = 0;
                    dp[1] = 1;

                4.确定遍历顺序
                从递归公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的

                5.举例推导dp数组
                按照这个递推公式dp[i] = dp[i - 1] + dp[i - 2]，我们来推导一下，当N为10的时候，dp数组应该是如下的数列：
                    0 1 1 2 3 5 8 13 21 34 55
             */

            if (n <= 1) {
                return n;
            }

            // 1.确定dp数组以及下标的含义
            // 3.dp数组初始化
            int[] dp = new int[2];
            dp[0] = 0;
            dp[1] = 1;
            // 4.确定遍历顺序——从前往后。dp[2] = dp[1] + dp[0]，所以 i 从2开始遍历
            for (int i = 2; i <= n; i++) {
                // 2.确定递推公式
                int sum = dp[1] + dp[0];
                dp[0] = dp[1];
                dp[1] = sum;
            }

            return dp[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}