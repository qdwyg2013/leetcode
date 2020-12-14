//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1379 👎 0

package com.leetcode.editor.cn;

/**
 * java:[14]最长公共前缀
 */
public class P14LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (null == strs || strs.length == 0) {
                return "";
            }

            // 方法一：横向扫描
            // 依次遍历每个字符串，更新最长公共前缀
            // 最长公共前缀
            String prefix = strs[0];
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                prefix = getLongestCommonPrefix(prefix, strs[i]);
                // 如果最长公共前缀prefix为空，则直接中断
                if (prefix.length() == 0) {
                    break;
                }
            }

            return prefix;


//            // 方法二：纵向扫描
//            // 依次比较相同列上的字符是否相同
//            // 取字符串的最小长度
//            int min = Integer.MAX_VALUE;
//            for (String str : strs) {
//                min = Math.min(min, str.length());
//            }
//
//            for (int i = 0; i < min; i++) {
//                char first = strs[0].charAt(i);
//                // 因为第一个字符串上面已用，所以可以跳过
//                for (int j = 1; j < strs.length; j++) {
//                    if (strs[j].charAt(i) != first) {
//                        return strs[0].substring(0, i);
//                    }
//                }
//            }
//
//            return strs[0].substring(0, min);
        }

        private String getLongestCommonPrefix(String prefix, String str) {
            int length = Math.min(prefix.length(), str.length());

            for (int i = 0; i < length; i++) {
                if (prefix.charAt(i) != str.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }

            return prefix.substring(0, length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}