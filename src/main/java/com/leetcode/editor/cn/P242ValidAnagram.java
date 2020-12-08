//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 311 👎 0

package com.dangdang.listener.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * java:[242]有效的字母异位词
 */
public class P242ValidAnagram {

    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
        System.out.println(solution.isAnagram("a", "b"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            // 1.排序
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            Arrays.sort(sChars);
//            Arrays.sort(tChars);
//            return Arrays.equals(sChars, tChars);

            // 2.哈希表
//            Map<Character, Integer> sMap = new HashMap<>();
//            char[] sChars = s.toCharArray();
//            for (char sChar : sChars) {
//                sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
//            }
//
//            char[] tChars = t.toCharArray();
//            for (char tChar : tChars) {
//                Integer count = sMap.get(tChar);
//                if (null == count) {
//                    return false;
//                }
//
//                if (count == 1) {
//                    sMap.remove(tChar);
//                } else {
//                    sMap.put(tChar, --count);
//                }
//            }
//
//            if (sMap.size() == 0) {
//                return true;
//            }
//
//            return false;

            // 3.字符
            int[] chars = new int[26];
            char[] sChars = s.toCharArray();
            for (char sChar : sChars) {
                chars[sChar - 'a']++;
            }

            char[] tChars = t.toCharArray();
            for (char tChar : tChars) {
                chars[tChar - 'a']--;
            }

            for (int c : chars) {
                if (c != 0) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}