//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1459 👎 0

package com.dangdang.web.service.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * java:[22]括号生成
 */
public class P22GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> result;

        public List<String> generateParenthesis(int n) {

            result = new ArrayList<>();
            // 递归
            generate(0, 0, n, "");

            return result;
        }

        private void generate(int left, int right, int n, String s) {

            // recursion termination
            if (left == n && right == n) {
                result.add(s);
                return;
            }

            // process logic in current level

            // drill down
            // 加左：左的数量 最大是 3
            if (left < n) {
                generate(left + 1, right, n, s + "(");
            }

            // 加右：左的数量 > 右的数量
            if (left > right) {
                generate(left, right + 1, n, s + ")");
            }


            // reverse the current level status if needed
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}