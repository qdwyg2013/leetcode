//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 717 👎 0

package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * java:[283]移动零
 */
public class P283MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {

            // 1.暴力
            // 非零左移
//            int j = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != 0) {
//                    nums[j++] = nums[i];
//                }
//            }
//            // 右侧置为0
//            for (; j < nums.length; j++) {
//                nums[j] = 0;
//            }

            // 2.双指针 位置置换
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i != index) {
//                    // 或 因为i 肯定大约 index
//                    if (i > index) {
                        nums[index] = nums[i];
                        nums[i] = 0;
                        // 或 因为nums[index]=0
//                        nums[i] = nums[index];
                    }
                    index++;
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}