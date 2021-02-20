//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 499 👎 0

package com.leetcode.editor.cn;

/**
 * java:[92]反转链表 II
 */
public class P92ReverseLinkedListIi {

    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // TO TEST
        LinkedNode test = new LinkedNode(3);
//        test.next = new LinkedNode(5);
//        test.next.next = new LinkedNode(3);
//        test.next.next.next = new LinkedNode(4);
//        test.next.next.next.next = new LinkedNode(5);
        System.out.println(solution.reverseBetween(test, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class LinkedNode {
     * int val;
     * LinkedNode next;
     * LinkedNode(int x) { val = x; }
     * }
     */
    class Solution {
        public LinkedNode reverseBetween(LinkedNode head, int m, int n) {

            // 迭代连接反转
            if (null == head) {
                return null;
            }

            LinkedNode prev = null;
            LinkedNode curr = head;
            // 1.前移m
            // prev为第m-1个节点，curr为第m个节点
            // 结果：m=1，n=n-m+1
            while (m > 1) {
                prev = curr;
                curr = curr.next;
                m--;
                n--;
            }

            // 2.反转节点间指向
            // 第m-1个节点 作为反转后的 prev
            LinkedNode con = prev;
            // 第m个节点 作为反转的尾部
            LinkedNode tail = curr;
            while (n > 0) {
                // 反转四步法
                LinkedNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;

                n--;
            }
            // 经过循环之后 curr 为第 n+1 个节点，prev 为第 n 个节点

            // 3.连接反转前部分
            if (con == null) {
                // 表示 m=1，所以con=null，故不存在con.next
                head = prev;
            } else {
                con.next = prev;
            }

            // 4.连接反转后部分
            tail.next = curr;

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}