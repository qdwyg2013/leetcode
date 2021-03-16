//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 772 👎 0

package com.leetcode.editor.cn.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java:[18]四数之和
 */
public class P18FourSum {

    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(solution.fourSum(nums, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> result = new ArrayList<>();

            // 方法：双指针法
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    // 去重
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    // 定义左右指针
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum < target) {
                            left++;
                            // 去重
                            while (right > left && nums[left] == nums[left - 1]) {
                                left++;
                            }
                        } else if (sum > target) {
                            right--;
                            // 去重
                            while (right > left && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            result.add(list);

                            left++;
                            right--;
                            // 去重
                            while (right > left && nums[left] == nums[left - 1]) {
                                left++;
                            }
                            while (right > left && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}