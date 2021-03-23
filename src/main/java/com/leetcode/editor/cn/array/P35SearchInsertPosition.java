//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 800 👎 0

package com.leetcode.editor.cn.array;

/**
 * java:[35]搜索插入位置
 */
public class P35SearchInsertPosition {

    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {

            /*
                总共下面四种情况：
                1.目标值在数组所有元素之前
                2.目标值等于数组中某一个元素
                3.目标值插入数组中的位置
                4.目标值在数组所有元素之后
             */
//            // 方法一：暴力法
//            // 时间复杂度：O(n)
//            // 空间复杂度：O(1)
//            for (int i = 0; i < nums.length; i++) {
//                // (1、2、3)当前值大于等于目标值，则索引即所需要的 (大于实现1、3；等于实现2)
//                if (nums[i] >= target) {
//                    return i;
//                }
//            }
//
//            // (4)若数组中的数都小于目标值，则将目标值插在最后
//            return nums.length;

            // 方法二：二分法 O(logn)
            // 只要看到面试题里给出的数组是有序数组，都可以想一想是否可以使用二分法。
            // 题中让“你可以假设数组中无重复元素。 ”，否则会又多个下标
            // 二分法1：左闭右闭
            // 时间复杂度：O(logn)
            // 空间复杂度：O(1)
            // 定义target在左闭右闭的区间里，[left, right]
            int left = 0;
            int right = nums.length - 1;
            // 当left==right，区间[left, right]依然有效
            while (left <= right) {
                // 防止溢出 等同于(left + right)/2
                int middle = left + (right - left) / 2;
                if (nums[middle] < target) {
                    // target 在右区间，所以[middle + 1, right]
                    left = middle + 1;
                } else if (nums[middle] > target) {
                    // target 在左区间，所以[left, middle - 1]
                    right = middle - 1;
                } else {
                    // 数组中找到目标值的情况，直接返回下标  nums[middle] == target
                    return middle;
                }
            }

            /*
                分别处理如下四种情况
                1.目标值在数组所有元素之前  [0, -1]，return  right + 1
                2.目标值等于数组中某一个元素  return middle;
                3.目标值插入数组中的位置 [left, right]，return  right + 1
                4.目标值在数组所有元素之后的情况 [left, right]， return right + 1
            */
            return right + 1;

            // 二分法2：左闭右开
//            // 时间复杂度：O(logn)
//            // 空间复杂度：O(1)
//            // 定义target在左闭右开的区间里，[left, right)  target
//            int left = 0;
//            int right = nums.length;
//            // 因为left == right的时候，在[left, right)是无效的空间
//            while (left < right) {
//                int middle = left + (right - left) / 2;
//                if (nums[middle] < target) {
//                    // target 在右区间，在 [middle+1, right)中
//                    left = middle + 1;
//                } else if (nums[middle] > target) {
//                    // target 在左区间，在[left, middle)中
//                    right = middle;
//                } else {
//                    // 数组中找到目标值的情况，直接返回下标  nums[middle] == target
//                    return middle;
//                }
//            }
//
//            /*
//                分别处理如下四种情况
//                1.目标值在数组所有元素之前  [0, 0]，return  right
//                2.目标值等于数组中某一个元素  return middle;
//                3.目标值插入数组中的位置 [left, right)，return  right
//                4.目标值在数组所有元素之后的情况 [left, right)， return right
//            */
//            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}