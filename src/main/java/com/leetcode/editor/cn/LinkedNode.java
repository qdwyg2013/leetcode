package com.leetcode.editor.cn;

import lombok.Data;

/**
 * 单链表
 */
@Data
public class LinkedNode {

    /**
     * 节点上存储的元素
     */
    int val;
    /**
     * 指向下一个节点的指针
     */
    LinkedNode next;

    LinkedNode(int val) {
        val = val;
    }

}
