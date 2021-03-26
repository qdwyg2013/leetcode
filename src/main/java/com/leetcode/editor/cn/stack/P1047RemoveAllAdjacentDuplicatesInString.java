//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 244 👎 0

package com.leetcode.editor.cn.stack;

import java.util.Stack;

/**
 * java:[1047]删除字符串中的所有相邻重复项
 */
public class P1047RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        Solution solution = new P1047RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String S) {

            // 方法：栈 stack
            // 可以把字符串顺序放到一个栈中，然后如果相同的话 栈就弹出，这样最后栈里剩下的元素都是相邻不相同的元素了。
            Stack<Character> stack = new Stack<>();
            char[] sc = S.toCharArray();
            for (char scc : sc) {
                if (stack.isEmpty() || stack.peek() != scc) {
                    stack.push(scc);
                } else {
                    // scc 与 stack.peek()相等的情况
                    stack.pop();
                }
            }

            // 将栈中元素放到result字符串汇总
            StringBuffer result = new StringBuffer();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            // 此时字符串需要反转一下
            return result.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}