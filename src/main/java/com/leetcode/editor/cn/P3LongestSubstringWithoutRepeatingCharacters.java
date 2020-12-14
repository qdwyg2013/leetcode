//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 3967 👎 0

package com.leetcode.editor.cn;

import java.util.*;

/**
 * java:[3]无重复字符的最长子串
 */
public class P3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        System.out.println(" ".length());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // 滑动窗口
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();
            // left 重复项的起点
            int left = 0;
            // i 向右移动
            for (int i = 0; i < s.length(); i++) {
                char cc = s.charAt(i);
                // 判断字符是否重复
                if (map.containsKey(cc)) {
                    // 重复则移动左节点，去除左侧重复字符
                    left = Math.max(left, map.get(cc) + 1);
                }
                map.put(cc, i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}