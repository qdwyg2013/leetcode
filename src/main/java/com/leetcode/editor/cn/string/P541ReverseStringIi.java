//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 117 👎 0

package com.leetcode.editor.cn.string;

/**
 * java:[541]反转字符串 II
 */
public class P541ReverseStringIi {

    public static void main(String[] args) {
        Solution solution = new P541ReverseStringIi().new Solution();
        // TO TEST
        System.out.println(solution.reverseStr("abcdefg", 2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseStr(String s, int k) {

            char[] ss = s.toCharArray();
            // 方法一
            for (int i = 0; i < ss.length; i += (2 * k)) {
                // 1. 每隔 2k 个字符的前 k 个字符进行反转
                // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
                if (i + k < ss.length) {
                    reverse(ss, i, i + k - 1);
                    continue;
                }

                // 3. 剩余字符少于 k 个，则将剩余字符全部反转。
                reverse(ss, i, ss.length - 1);
            }

            // 方法二
//            for (int i = 0; i < ss.length; i += (2 * k)) {
//                int start = i;
//                int end = Math.min(i + k - 1, ss.length - 1);
//
//                while (start < end) {
//                    // swap 互换字符
//                    char temp = ss[start];
//                    ss[start] = ss[end];
//                    ss[end] = temp;
//
//                    start++;
//                    end--;
//                }
//            }

            return new String(ss);
        }

        private void reverse(char[] s, int start, int end) {

            while (start < end) {
                // swap 互换字符
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;

                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}