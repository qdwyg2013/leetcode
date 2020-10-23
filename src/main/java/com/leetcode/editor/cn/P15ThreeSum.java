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
//                // 去重。排序后前后两项的值相同，只能记录一个
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

            // 方法二：双指针法  两边夹
//            // https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
//            Arrays.sort(nums);
//            // 符号相同，则无解
//            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
//                return result;
//            }
//
//            for (int k = 0; k < nums.length - 2; k++) {
//                // 符号相同，则无解
//                if (nums[k] > 0) {
//                    return result;
//                }
//                // 跳过相同的 i
//                // 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
//                if (k > 0 && nums[k] == nums[k - 1]) {
//                    continue;
//                }
//                int i = k + 1;
//                int j = nums.length - 1;
//                while (i < j) {
//                    // 符号相同，则无解
//                    if (nums[j] < 0) {
//                        break;
//                    }
//
//                    /*
//                        当s < 0时，i += 1并跳过所有重复的nums[i]；
//                        当s > 0时，j -= 1并跳过所有重复的nums[j]；
//                        当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
//                     */
//                    int s = nums[i] + nums[j] + nums[k];
//                    if (s < 0) {
//                        i++;
//                        // 跳过相同的 l
//                        while (i < j && nums[i] == nums[i - 1]) {
//                            i++;
//                        }
//                    } else if (s > 0) {
//                        j--;
//                        // 跳过相同的 r
//                        while (i < j && nums[j] == nums[j + 1]) {
//                            j--;
//                        }
//                    } else if (s == 0) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[k]);
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        result.add(list);
//
//                        i++;
//                        j--;
//                        // 跳过相同的 l
//                        while (i < j && nums[i] == nums[i - 1]) {
//                            i++;
//                        }
//                        // 跳过相同的 r
//                        while (i < j && nums[j] == nums[j + 1]) {
//                            j--;
//                        }
//                    }
//                }
//            }

            Arrays.sort(nums);
            // 符号一样，则无解
            if (nums[0] > 0 || nums[nums.length - 1] < 0)
                return result;

            for (int i = 0; i < nums.length - 2; i++) {
                // 符号一样，则无解
                if (nums[i] > 0)
                    return result;
                // 过滤重复 i
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    // 符号一样，则无解
                    if (nums[k] < 0)
                        break;

                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        // 当sum < 0时，j += 1并跳过所有重复的nums[j]
                        // TODO 为何会降低速度
//                        while (j < k && nums[j] == nums[++j]){}
                        j++;
                    } else if (sum > 0) {
                        // 当sum > 0时，k -= 1并跳过所有重复的nums[k]
//                        while (j < k && nums[k] == nums[--k]){}
                        k--;
                    } else {
                        // 当sum == 0时，记录组合[i, j, k]result，
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        // 执行j += 1和k -= 1，并跳过所有重复的nums[j]和nums[k]，防止记录到重复组合
                        while (j < k && nums[j] == nums[++j]){}
                        while (j < k && nums[k] == nums[--k]){}
                    }
                }

            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}