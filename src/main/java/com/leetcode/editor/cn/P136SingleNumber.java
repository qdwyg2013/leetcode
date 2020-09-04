//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1426 👎 0

package com.leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * java:[136]只出现一次的数字
 */
public class P136SingleNumber {

    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        // TO TEST
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {

            // 方法一
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num : nums) {
//                if (null == map.get(num)) {
//                    map.put(num, 1);
//                } else if (map.get(num) == 1) {
//                    map.put(num, 2);
//                }
//            }
//
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                if (entry.getValue() == 1) {
//                    return entry.getKey();
//                }
//            }
//
//            return 0;

            // 方法二
            /*
                异或运算有以下三个性质。
                1.任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
                2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
                3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
             */
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}