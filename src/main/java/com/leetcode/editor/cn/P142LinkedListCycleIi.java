//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 776 👎 0

package com.leetcode.editor.cn;

/**
 * java:[142]环形链表 II
 */
public class P142LinkedListCycleIi {

    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class LinkedNode {
     * int val;
     * LinkedNode next;
     * LinkedNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public LinkedNode detectCycle(LinkedNode head) {

            // 1.哈希表（无重复）
//        Set<LinkedNode> listNodeSet = new HashSet<>();
//        while (null != head) {
//            // 遇到的第一个遍历过的节点必然是入环点
//            if (listNodeSet.contains(head)) {
//                return head;
//            }
//
//            listNodeSet.add(head);
//            head = head.next;
//        }
//
//        return null;


            // 2.快慢指针
            /*
                设链表中环外部分的长度为 a
                slow 指针进入环后，又走了 b 的距离与 fast 相遇（入环后按照顺时针方向走）；相遇点 按顺时针方向距离环入口的距离为 c。所以环周长为 b+c

                假设相遇时 fast 指针已经走完了环的 n 圈，因此 fast 指针走过的总距离为 a+n(b+c)+b = a+(n+1)b+nc
                因为fast指针走过的路程是slow指针的两倍，所以 a+(n+1)b+nc = 2(a+b)，即a = c+(n−1)(b+c)
                所以从相遇点到入环点的距离 c 加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。

                因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。
                起始，它指向链表头部；
                随后，ptr 和 slow 每次向后移动一个位置；
                最终，它们会在入环点相遇 a = c+(n−1)(b+c)
             */
            if (null == head || null == head.next) {
                return null;
            }

            // 获取快慢指针相遇点
            LinkedNode slow = head;
            LinkedNode fast = head;
            while (true) {
                if (null == fast || null == fast.next) {
                    return null;
                }

                slow = slow.next;
                fast = fast.next.next;
                // 获取快慢指针相遇点
                if (slow == fast) {
                    break;
                }
            }

            // 获取入环点
            LinkedNode ptr = head;
            while (ptr != slow) {
                ptr = ptr.next;
                slow = slow.next;
            }

            return ptr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}