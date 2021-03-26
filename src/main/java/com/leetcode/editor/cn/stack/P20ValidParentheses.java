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

package com.leetcode.editor.cn.stack;

import java.util.Stack;

/**
 * java:[20]有效的括号
 */
public class P20ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            // 方法1：暴力 替换
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

            // 方法2：栈 + map 先进后出 FILO 先进左括号，看到右括号时，则带出左括号
//            if (s.length() % 2 == 1) {
//                return false;
//            }
//
//            // 栈中存左括号，利用左括号相等
//            // key: 右；value: 左
//            Map<Character, Character> map = new HashMap<>();
//            map.put(')', '(');
//            map.put(']', '[');
//            map.put('}', '{');
//
//            Stack<Character> stack = new Stack<>();
//            for (int i = 0; i < s.length(); i++) {
//                char chatat = s.charAt(i);
//                if (map.containsKey(chatat)) {
//                    // 遇到 右括号，则栈的第一个字符必然是与其匹配的 左括号，从而互相抵消
//                    if (stack.isEmpty() || !map.get(chatat).equals(stack.peek())) {
//                        return false;
//                    }
//                    stack.pop();
//                } else {
//                    // 遇到 左括号，放入栈中
//                    stack.push(chatat);
//                }
//            }
//
//            if (stack.isEmpty()) {
//                return true;
//            }
//            return false;

            // 方法3：栈
            if (s.length() % 2 == 1) {
                return false;
            }

            // 栈中存右括号，利用右括号相等
            /*
                第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
                第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
                第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false
             */
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ci = s.charAt(i);
                if ('(' == ci) {
                    stack.push(')');
                } else if ('[' == ci) {
                    stack.push(']');
                } else if ('{' == ci) {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.peek() != ci) {
                    // 第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
                    // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false
                    return false;
                } else {
                    stack.pop();
                }
            }

            // 第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}