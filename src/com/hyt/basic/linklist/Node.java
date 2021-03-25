package com.hyt.basic.linklist;

/**
 * @author houyutao
 * @date 2021-02-05
 */
public class Node {

    int value;

    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    void print() {
        Node p = this;
        while (p.next != null) {
            System.out.print(p.value + ",");
            p = p.next;
        }
        System.out.println(p.value);
    }
}
