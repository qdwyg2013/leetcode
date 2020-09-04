//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2507 👎 0

package com.leetcode.editor.cn;

import org.springframework.cglib.core.CollectionUtils;

import java.util.*;

/**
 * java:[15]三数之和
 */
public class P15ThreeSum {

    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        int[] nums = new int[]{0,0,0,0};
        System.out.println(solution.threeSum(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            // 方法一：暴力
//            List<List<Integer>> result = new ArrayList<>();
//            Arrays.sort(nums);
//            for (int i = 0; i < nums.length - 2; i++) {
//                if (i > 0 && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    if (j > i + 1 && nums[j] == nums[j - 1]) {
//                        continue;
//                    }
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (k > j + 1 && nums[k] == nums[k - 1]) {
//                            continue;
//                        }
//                        if (nums[i] + nums[j] + nums[k] == 0) {
//                            List<Integer> list = new ArrayList<>();
//                            list.add(nums[i]);
//                            list.add(nums[j]);
//                            list.add(nums[k]);
//                            result.add(list);
//                        }
//                    }
//                }
//            }
//            return result;

            // 方法二：两边夹
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[l] + nums[r] + nums[i];
                    if (sum > 0) {
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);

                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}