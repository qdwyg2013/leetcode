//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 326 👎 0

package com.leetcode.editor.cn.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * java:[349]两个数组的交集
 */
public class P349IntersectionOfTwoArrays {

    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            // 方法1：set集合
            // O(m+n) 其中 m 和 n 是两个数组的长度
            Set<Integer> resultSet = new HashSet<>();
            // nums1去重
            Set<Integer> nums1Set = new HashSet<>();
            for (int num : nums1) {
                nums1Set.add(num);
            }

            // 遍历nums2，查询nums2中的元素是否存在于nums1中
            for (int num : nums2) {
                if (nums1Set.contains(num)) {
                    resultSet.add(num);
                }
            }

            // 集合转int数组
            int[] result = new int[resultSet.size()];
            int index = 0;
            for (Integer res : resultSet) {
                result[index++] = res;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}