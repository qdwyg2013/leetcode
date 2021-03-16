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

package com.leetcode.editor.cn.hash;

import java.util.*;

/**
 * java:[15]三数之和
 */
public class P15ThreeSum {

    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        int[] nums = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(solution.threeSum(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            if (null == nums || nums.length < 3) {
                return result;
            }
            // 方法一：暴力
//            // 从小到大排序后方便去重
//            Arrays.sort(nums);
//            for (int i = 0; i < nums.length - 2; i++) {
//                // 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
//                if (nums[i] > 0) {
//                    continue;
//                }
//                // 去重。排序后前后两项的值相同，只能记录一个
//                // 因为前一个肯定跟后面不相同的项都做过求和比较了，所以后一个相同项就没必要做了
//                if (i > 0 && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    // 去重
//                    if (j > i + 1 && nums[j] == nums[j - 1]) {
//                        continue;
//                    }
//                    for (int k = j + 1; k < nums.length; k++) {
//                        // 去重
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

            // 方法二：hash
//            // 从小到大排序后方便去重
//            Arrays.sort(nums);
//            for (int i = 0; i < nums.length - 1; i++) {
//                // 排序之后如果第一个元素已经大于零，那么不可能凑成三元组
//                if (nums[i] > 0) {
//                    continue;
//                }
//                // 去重。排序后前后两项的值相同，只能记录一个
//                // 因为前一个肯定跟后面不相同的项都做过求和比较了，所以后一个相同项就没必要做了
//                if (i > 0 && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                Set<Integer> set = new HashSet<>();
//                for (int j = i + 1; j < nums.length; j++) {
//                    // 去重
//                    if (j > i + 2
//                            && nums[j] == nums[j - 1]
//                            && nums[j - 1] == nums[j - 2]) {
//                        continue;
//                    }
//                    int c = 0 - (nums[i] + nums[j]);
//                    if (set.contains(c)) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(c);
//                        result.add(list);
//                    } else {
//                        set.add(c);
//                    }
//                }
//            }

            // 方法三：双指针法  两边夹
            // https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
            Arrays.sort(nums);
            // 符号相同，则无解
            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return result;
            }

            for (int i = 0; i < nums.length - 2; i++) {
                // 符号相同，则无解
                if (nums[i] > 0) {
                    return result;
                }
                // 去重，跳过相同的 i
                // 当 i > 0且nums[i] == nums[i - 1]时即跳过此元素nums[i]：
                // 因为已经将 nums[i - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 定义一个下表left 在i+1的位置上，定义下表right 在数组结尾的位置上。
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 符号相同，则无解
                    if (nums[right] < 0) {
                        break;
                    }

                    /*
                        当sum < 0时，left += 1并跳过所有重复的nums[left]；
                        当sum > 0时，right -= 1并跳过所有重复的nums[right]；
                        当sum == 0时，记录组合[i, left, right]至res，执行left += 1和right -= 1并跳过所有重复的nums[left]和nums[right]，防止记录到重复组合。
                     */
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        left++;
                        // 跳过相同的 left
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (sum > 0) {
                        right--;
                        // 跳过相同的 right
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);

                        // 找到答案时，双指针同时收缩
                        left++;
                        right--;
                        // 跳过相同的 left
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        // 跳过相同的 right
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}