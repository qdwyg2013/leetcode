//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3066 👎 0

package com.leetcode.editor.cn.greedy;

/**
 * java:[53]最大子序和
 */
public class P53MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {

            // 方法：
            // 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
            // 从而推出全局最优：选取最大“连续和”
            int result = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                // 取区间累计的最大值（相当于不断确定最大子序终止位置）
                if (sum > result) {
                    result = sum;
                }
                // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
                if (sum < 0) {
                    sum = 0;
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}