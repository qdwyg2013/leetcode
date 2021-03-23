//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 86 👎 0

package com.leetcode.editor.cn.string;

/**
 * java:[剑指 Offer 05]替换空格
 */
public class POffer05TiHuanKongGeLcof {

    public static void main(String[] args) {
        Solution solution = new POffer05TiHuanKongGeLcof().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {

            // 方法：从后向前填充数组
            /*
                从后向前遍历填充数组的好处：
                1.不用申请新数组。
                2.从后向前填充元素，避免了从前先后填充元素要来的 每次添加元素都要将添加元素之后的所有元素向后移动。
             */
            // 字符串的长度
            int oldSize = s.length();
            // 空格的数量
            int spaceCount = 0;
            char[] oldS = s.toCharArray();
            for (char os : oldS) {
                if (os == ' ') {
                    spaceCount++;
                }
            }

            // 扩充字符串s的大小，也就是每个空格替换成"%20"之后的大小
            char[] newS = new char[oldSize + spaceCount * 2];

            // 从后先前将空格替换为"%20"
            int newSize = newS.length;
            for (int i = oldSize - 1, j = newSize - 1; i < j; i--) {
                if (oldS[i] == ' ') {
                    newS[j] = '0';
                    newS[j - 1] = '2';
                    newS[j - 2] = '%';
                    j -= 3;
                } else {
                    newS[j] = oldS[i];
                    j--;
                }
            }

            return new String(newS);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}