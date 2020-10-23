//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1840 👎 0

package com.leetcode.editor.cn;

import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * java:[20]有效的括号
 */
public class P20ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            // 1.暴力 替换
//            int count = 1;
//            String a = "";
//            while (count > 0) {
//                count = 0;
//                a = s.replaceAll("\\(\\)", "").replaceAll("\\[]", "").replaceAll("\\{}", "");
//                if (a.equals("") || null == a) {
//                    return true;
//                } else if (!a.equals(s)) {
//                    count++;
//                }
//                s = a;
//            }
//
//            return false;

            // 2.栈 后进先出
            if (s.length() % 2 == 1) {
                return false;
            }

            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char chatat = s.charAt(i);
                if (map.containsKey(chatat)) {
                    if (map.get(chatat).equals(stack.pop())){

                    }

                }
                if (chatat == '(') {
                    stack.push(chatat);
                } else if (chatat == '[') {
                    stack.push(chatat);
                } else if (chatat == '{') {
                    stack.push(chatat);
                } else if (stack.isEmpty() || chatat != stack.pop()) {
                    return false;
                }
            }

            if (stack.empty()) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}