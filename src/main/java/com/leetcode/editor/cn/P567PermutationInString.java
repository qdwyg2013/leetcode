//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 206 👎 0

package com.leetcode.editor.cn;

import java.util.Arrays;

/**
 * java:[567]字符串的排列
 */
public class P567PermutationInString {

    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
        solution.checkInclusion("adc", "dcda");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            // 方法一：排序
            s1 = sort(s1);
            // 因为要对s2截取，所以遍历长度 s2.length() - s1.length() 即可
            for (int i = 0; i <= s2.length() - s1.length(); i++) {
                // 针对相同数量的字符排序
                String ss2 = sort(s2.substring(i, i + s1.length()));
                if (s1.equals(ss2)) {
                    return true;
                }
            }

            return false;
        }

        private String sort(String s) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}