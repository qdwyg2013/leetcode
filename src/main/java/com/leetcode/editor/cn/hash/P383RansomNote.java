//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 136 👎 0

package com.leetcode.editor.cn.hash;

/**
 * java:[383]赎金信
 */
public class P383RansomNote {

    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {

            // 方法一：暴力
//            for (int i = 0; i < magazine.length(); i++) {
//                for (int j = 0; j < ransomNote.length(); j++) {
//                    // 在ransomNote中找到和magazine相同的字符
//                    if (magazine.charAt(i) == ransomNote.charAt(j)) {
//                        // ransomNote删除这个字符
//                        ransomNote = ransomNote.substring(0, j) + ransomNote.substring(j + 1);
//                        break;
//                    }
//                }
//            }
//
//            // 如果ransomNote为空，则说明magazine的字符可以组成ransomNote
//            if (ransomNote.length() == 0) {
//                return true;
//            }
//
//            return false;

            // 方法二：hash解法：数组
            // 时间复杂度: O(n)
            // 空间复杂度：O(1)
            int[] record = new int[26];
            // 通过recode数据记录 magazine里各个字符出现次数
            for (int i = 0; i < magazine.length(); i++) {
                record[magazine.charAt(i) - 'a']++;
            }

            // 遍历ransomNote，在record里对应的字符个数做--操作
            for (int j = 0; j < ransomNote.length(); j++) {
                record[ransomNote.charAt(j) - 'a']--;

                // 如果小于零说明 magazine里出现的字符，ransomNote没有
                if (record[ransomNote.charAt(j) - 'a'] < 0) {
                    return false;
                }
            }

            return true;

            // 方法三：hash解法：map
//            Map<Character, Integer> recordMap = new HashMap<>();
//            // 通过recode数据记录 magazine里各个字符出现次数
//            for (int i = 0; i < magazine.length(); i++) {
//                char maga = magazine.charAt(i);
//                recordMap.put(maga, recordMap.getOrDefault(maga, 0) + 1);
//            }
//
//            // 遍历ransomNote，在record里对应的字符个数做--操作
//            for (int j = 0; j < ransomNote.length(); j++) {
//                char ran = ransomNote.charAt(j);
//                recordMap.put(ran, recordMap.getOrDefault(ran, 0) - 1);
//
//                // 如果小于零说明 magazine里出现的字符，ransomNote没有
//                if (recordMap.get(ran) < 0) {
//                    return false;
//                }
//            }
//
//            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}