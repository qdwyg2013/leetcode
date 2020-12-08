//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 👍 706 👎 0

package com.leetcode.editor.cn;

import java.util.Stack;

/**
 * java:[155]最小栈
 */
public class P155MinStack {

    public static void main(String[] args) {
        MinStack solution = new P155MinStack().new MinStack();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        private Stack<Integer> stack;
        // 最小栈 的栈顶元素永远为最小值
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        // 方法一：最小栈中都是有效元素，在pop时判断最小栈是否pop栈顶元素
//        public MinStack() {
//            stack = new Stack<>();
//            minStack = new Stack<>();
//        }
//
//        public void push(int x) {
//            stack.push(x);
//            // push 时将最小值放入最小栈
//            if (minStack.isEmpty() || minStack.peek() >= x) {
//                minStack.push(x);
//            }
//        }
//
//        public void pop() {
//            // pop 时，如果stack的栈顶元素跟最小栈的栈顶元素相同，则最小栈也需要pop
//            if (stack.pop().equals(minStack.peek())) {
//                minStack.pop();
//            }
//        }
//
//        public int top() {
//            return stack.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }

        // 方法二：最小栈中元素和正常栈中元素数量保持一致。
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            // 保证最小栈中用于多一个元素，所以无需进行非空判断
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            // push 时往最小栈中放入栈顶与x最小的元素（说明：如果栈顶小，则会重复放入最小栈）
            minStack.push(Math.min(x, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}