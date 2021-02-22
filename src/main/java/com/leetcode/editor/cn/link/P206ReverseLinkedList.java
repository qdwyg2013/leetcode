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

package com.leetcode.editor.cn.link;

import com.leetcode.editor.cn.ListNode;

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
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {

            // 方法一：双指针法
            // 即：改变链表的next指针的指向，直接将链表反转
            ListNode prev = null;
            ListNode curr = head;
            // 当cur为空的时候循环结束
            while (curr != null) {
            /*
                curr = a->b->c->null
                prev = null
                反转后：null<-a (prev), (curr) b->c->null

                curr = b->c->null
                prev = null<-a
                反转后：null<-a<-b (prev), (curr) c->null

                curr = c->null
                prev = null<-a<-b
                反转后：null<-a<-b<-c (prev), (curr) null
             */
                // 保存一下cur的下一个节点，因为接下来要改变cur->next
                ListNode temp = curr.next;
                // 反转操作
                curr.next = prev;
                // 更新pre 和 cur指针
                prev = curr;
                curr = temp;
            }

            return prev;

            // 方法二：递归 (跟双指针法异曲同工)
////        ListNode prev = null;
////        ListNode curr = head;
//            // 初始化参数和双指针法初始化是一样的逻辑
//            return reverse(null, head);
        }

        private ListNode reverse(ListNode prev, ListNode curr) {
            // 结束递归的条件和双指针法结束循环的方式是一样的逻辑
            if (curr == null) {
                return prev;
            }

            // 反转操作的逻辑跟双指针法一样
            ListNode temp = curr.next;
            curr.next = prev;

            // 更新pre 和 cur指针
//            prev = curr;
//            curr = temp;
            // 可以和双指针法的代码进行对比，如下递归的写法，其实就是做了上面两步
            return reverse(curr, temp);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}