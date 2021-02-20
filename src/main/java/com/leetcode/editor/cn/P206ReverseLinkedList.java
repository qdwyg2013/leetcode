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

/**
 * java:[206]反转链表
 */
public class P206ReverseLinkedList {

    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
        LinkedNode test = new LinkedNode(1);
        test.next = new LinkedNode(2);
        test.next.next = new LinkedNode(3);
        test.next.next.next = new LinkedNode(4);
        test.next.next.next.next = new LinkedNode(5);
        System.out.println(solution.reverseList(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class LinkedNode {
 *     int val;
 *     LinkedNode next;
 *     LinkedNode(int x) { val = x; }
 * }
 */
class Solution {
    public LinkedNode reverseList(LinkedNode head) {

        // 1.迭代反转
        LinkedNode prev = null;
        LinkedNode curr = head;
        while (curr != null) {
            /*
                每次反转一个箭头 ->
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
            LinkedNode temp = curr.next;
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