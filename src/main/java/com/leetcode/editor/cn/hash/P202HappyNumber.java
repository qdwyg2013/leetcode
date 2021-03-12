//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//1^2 + 9^2 = 82 (1和9的平方和)
//8^2 + 2^2 = 68 (8和2的平方和)
//6^2 + 8^2 = 100 (6和8的平方和)
//1^2 + 0^2 + 0^2 = 1 (1、0和0的平方和)
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 537 👎 0

package com.leetcode.editor.cn.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * java:[202]快乐数
 */
public class P202HappyNumber {

    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {

            // 方法：hash解法：set
            Set<Integer> set = new HashSet<>();
            while (true) {
                // 计算n每个位置上的数字的平方和
                int sum = getSum(n);
                // sum == 1，说明是快乐数
                if (sum == 1) {
                    return true;
                }

                // 若sum在前面已经出现过，说明已经陷入无限循环了，立刻return false
                if (set.contains(sum)) {
                    return false;
                }
                // 将sum放入set，记录出现过的sum
                set.add(sum);

                n = sum;
            }
        }

        /**
         * 计算n每个位置上的数字的平方和
         */
        private int getSum(int n) {

            int sum = 0;
            while (n > 0) {
                // 通过取余，获取n最后一位数字
                int remainder = n % 10;
                sum += remainder * remainder;
                // 通过求商，获取n前n-1位数字
                n /= 10;
            }

            return sum;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}