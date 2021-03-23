//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 539 👎 0

package com.leetcode.editor.cn.array;

/**
 * java:[209]长度最小的子数组
 */
public class P209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {

            // 方法一：暴力
            // 时间复杂度：O(n^2)
            // 空间复杂度：O(1)
            // 最终的结果
//            int minSubArrayLen = Integer.MAX_VALUE;
//            // 设置子序列起点为i
//            for (int i = 0; i < nums.length; i++) {
//                // 子序列的数值之和
//                int sum = 0;
//                // 设置子序列终止位置为j (注意此处从j=i开始，若从i+1开始，for外面还需做一次if判断)
//                for (int j = i; j < nums.length; j++) {
//                    sum += nums[j];
//                    // 一旦发现子序列和超过了s(注意是>=)，更新minSubArrayLen
//                    if (sum >= s) {
//                        // 子序列的长度
//                        int curSubArrayLen = j - i + 1;
//                        minSubArrayLen = Math.min(minSubArrayLen, curSubArrayLen);
//                        // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
//                        break;
//                    }
//                }
//            }
//
//            // 如果minSubArrayLen没有被赋值的话，就返回0，说明没有符合条件的子序列
//            return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;

            // 方法二：滑动窗口
            // 时间复杂度：O(n)
            // 空间复杂度：O(1)
            // 最终的结果
            int minSubArrayLen = Integer.MAX_VALUE;
            // 滑动窗口数值之和
            int sum = 0;
            // 滑动窗口起始位置
            int start = 0;
            // end滑动窗口结束为止
            for (int end = 0; end < nums.length; end++) {
                sum += nums[end];
                // 注意这里使用while，每次更新 start（起始位置），并不断比较子序列是否符合条件
                while (sum >= s) {
                    // 滑动窗口的长度
                    int currSubArrayLen = end - start + 1;
                    minSubArrayLen = Math.min(minSubArrayLen, currSubArrayLen);
                    // 这里体现出滑动窗口的精髓之处，不断前移start（滑动窗口的起始位置）
                    sum -= nums[start++];
                }
            }

            // 如果minSubArrayLen没有被赋值的话，就返回0，说明没有符合条件的子序列
            return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}