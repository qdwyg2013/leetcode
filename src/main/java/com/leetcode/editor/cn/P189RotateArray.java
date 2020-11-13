//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 654 👎 0

package com.leetcode.editor.cn;

import com.sun.deploy.util.ArrayUtil;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;

/**
 * java:[189]旋转数组
 */
public class P189RotateArray {

    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
        int[] nums = new int[]{-1, -100, 3, 99};
        solution.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {

            // 方法一：移动
//            for (int i = 0; i < k; i++) {
//                int lastNum = nums[nums.length - 1];
//                // 前n-1个往后移动一位
//                for (int j = nums.length - 2; j >= 0; j--) {
//                    nums[j + 1] = nums[j];
//                }
//                // 将最后一位赋值给第一个位置
//                nums[0] = lastNum;
//            }

            // 方法二：反转
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        /**
         * 前后互换位置
         *
         * @param nums
         * @param start
         * @param end
         */
        public void reverse(int[] nums, int start, int end) {

            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}