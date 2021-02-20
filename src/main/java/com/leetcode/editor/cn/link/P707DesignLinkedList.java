//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 
// 👍 209 👎 0

package com.leetcode.editor.cn.link;

/**
 * java:[707]设计链表
 */
public class P707DesignLinkedList {

    public static void main(String[] args) {
        MyLinkedList solution = new P707DesignLinkedList().new MyLinkedList();
        // TO TEST
        solution.addAtHead(1);
        solution.addAtTail(3);
        solution.addAtIndex(1, 2);
        solution.get(1);
        solution.deleteAtIndex(1);
        solution.get(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        class LinkedNode {
            /**
             * 节点上存储的元素
             */
            int val;
            /**
             * 指向下一个节点的指针
             */
            LinkedNode next;

            LinkedNode(int val) {
                this.val = val;
            }
        }

        private LinkedNode dummyHead;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            // 这里定义的头结点 是一个虚拟头结点，而不是真正的链表头结点
            dummyHead = new LinkedNode(0);
            // 初始化链表的长度
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         * 获取到第index个节点数值，如果index是非法数值直接返回-1， 注意index是从0开始的，第0个节点就是头结点
         */
        public int get(int index) {
            if (index > size - 1 || index < 0) {
                return -1;
            }

            LinkedNode curr = dummyHead.next;
            while (index > 0) {
                curr = curr.next;
                index--;
            }

            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         * 在链表最前面插入一个节点，插入完成后，新插入的节点为链表的新的头结点
         */
        public void addAtHead(int val) {
            LinkedNode newNode = new LinkedNode(val);
            // 插入节点 三步走
            LinkedNode temp = dummyHead.next;
            dummyHead.next = newNode;
            newNode.next = temp;

            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         * 在链表最后面添加一个节点
         */
        public void addAtTail(int val) {
            LinkedNode newNode = new LinkedNode(val);
            LinkedNode curr = dummyHead;
            // 遍历到最后一个节点
            while (curr.next != null) {
                curr = curr.next;
            }
            // 将原链表的最后一个节点next指针，指向新节点。因为新节点next指针本来就指向null，所以无需特意对其赋值
            curr.next = newNode;

            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         * 在第index个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
         * 如果index 等于链表的长度，则说明是新插入的节点为链表的尾结点
         * 如果index 大于链表的长度，则返回空
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            LinkedNode newNode = new LinkedNode(val);
            LinkedNode curr = dummyHead;
            // 因为多了虚拟头结点，所以由插在原链表index位置的前面 变为 插在新链表(含有虚拟头结点)index位置的后面
            while (index > 0) {
                curr = curr.next;
                index--;
            }

            // 插入节点 三步走
            LinkedNode temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;

            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         * 删除第index个节点，如果index 大于等于链表的长度，直接return，注意index是从0开始的
         */
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }

            LinkedNode curr = dummyHead;
            while (index > 0) {
                curr = curr.next;
                index--;
            }

            // 删除节点
            curr.next = curr.next.next;

            size--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}