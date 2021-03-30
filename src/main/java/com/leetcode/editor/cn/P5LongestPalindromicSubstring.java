//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3434 👎 0

package com.leetcode.editor.cn;

/**
 * java:[5]最长回文子串
 */
public class P5LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            // 方法一：动态规划

            // 方法二：中心扩展算法
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                // 有中心值
                int len1 = expandAroundCenter(s, i, i);
                // 无中心值
                int len2 = expandAroundCenter(s, i, i + 1);
                // 回文串长度
                int len = Math.max(len1, len2);
                // 计算回文串开始、结束位置
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            // 因为上面left--，right++，左后一次循环会导致多加了2，所以要减2。即 right - left + 1 - 2 = right - left - 1
            return right - left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}