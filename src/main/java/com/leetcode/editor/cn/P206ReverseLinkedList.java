//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1186 👎 0

package com.leetcode.editor.cn;

import javafx.beans.binding.When;

import java.util.List;

/**
 * java:[206]反转链表
 */
public class P206ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        System.out.println(solution.reverseList(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        // 1.迭代反转
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            /*
                null->a->b->c
                curr = a
                a->null, a(prev)->b(curr)

                curr = b
                b->a, b(prev)->c(curr)
                (b->a->null)

                curr = c
                c->b, c(prev)->null(curr)
                (c->b->a->null)
             */
            ListNode temp = curr.next;
            // 前一个节点 作为 当前节点的下一个节点 —— 反转
            curr.next = prev;
            // 当前节点 作为 下一次的当前节点的 前一个节点
            prev = curr;
            // 下一个节点 作为 下一次的当前节点
            curr = temp;
        }

        return prev;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}