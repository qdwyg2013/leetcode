//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
// 输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 535 👎 0

package com.leetcode.editor.cn.link;

import com.leetcode.editor.cn.ListNode;

/**
 * java:[203]移除链表元素
 */
public class P203RemoveLinkedListElements {

    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            /*
                删除节点：
                        curr.next = curr.next.next; // 即将当前节点的next指针 指向 当前节点的下下个节点)
                添加节点：
                        ListNode temp = curr.next;
                        curr.next = newNode;
                        newNode.next = temp;
             */
            // 方法一：直接使用原来的链表来进行移除节点操作(对头结点需要考虑单独删除)
//            // 先删除头结点(注意：这里是while)
//            while (head != null && head.val == val) {
//                head = head.next;
//            }
//
//            // 再删除非头结点
//            ListNode curr = head;
//            while (curr.next != null) {
//                if (curr.next.val == val) {
//                    curr.next = curr.next.next;
//                } else {
//                    curr = curr.next;
//                }
//            }
//
//            return head;

            // 方法二：设置一个虚拟头结点在进行移除节点操作(不需单独考虑头结点的删除)
            // 设置一个虚拟头结点
            ListNode dummyHead = new ListNode(0);
            // 将虚拟头结点指向head，这样后面做删除操作就不需要单独对头结点做删除了
            dummyHead.next = head;

            ListNode curr = dummyHead;
            while (curr.next != null) {
                if (curr.next.val == val) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}