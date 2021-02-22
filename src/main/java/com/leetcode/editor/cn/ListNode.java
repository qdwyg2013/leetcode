package com.leetcode.editor.cn;

import lombok.Data;

/**
 * 单链表
 */
@Data
public class ListNode {

    /**
     * 节点上存储的元素
     */
    public int val;
    /**
     * 指向下一个节点的指针
     */
    public ListNode next;

    public ListNode(int val) {
        val = val;
    }

}
