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

package com.leetcode.editor.cn.hash;

/**
 * java:[242]有效的字母异位词
 * 说明：无需考虑字符串中字符的顺序
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

            // 方法1：排序
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            Arrays.sort(sChars);
//            Arrays.sort(tChars);
//            return Arrays.equals(sChars, tChars);

            // 方法二：数组
            // 因为字符a到字符z的ASCII是26个连续的数值，所以定义数组的长度为26，字符a映射为下表0，相应的字符z映射为下表25
            int[] record = new int[26];

            // 遍历字符串s的时候，只需要将 s[i] - 'a' 所在的元素做+1 操作即可。这样就将字符串s中字符出现的次数，统计出来了。
            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a']++;
            }
            // 遍历字符串t的时候，对t中出现的字符映射哈希表索引上的数值再做-1的操作
            for (int i = 0; i < t.length(); i++) {
                record[t.charAt(i) - 'a']--;
            }

            // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            for (int i = 0; i < record.length; i++) {
                if (record[i] != 0) {
                    return false;
                }
            }

            // record数组所有元素都为零0，说明字符串s和t是字母异位词
            return true;

            // 2.哈希表
//            // 加 +
//            Map<Character, Integer> sMap = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
//            }
//
//            // 减 -
//            for (int i = 0; i < t.length(); i++) {
//                Integer count = sMap.get(t.charAt(i));
//                if (null == count) {
//                    return false;
//                }
//
//                if (count == 1) {
//                    sMap.remove(t.charAt(i));
//                } else {
//                    sMap.put(t.charAt(i), --count);
//                }
//            }
//
//            if (sMap.size() == 0) {
//                return true;
//            }
//
//            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}