package com.hyt.basic.linklist;

/**
 * @author houyutao
 * @date 2021-02-05
 */
public class LinkNode {

    public static Node createNode(int[] data) {

        Node node = new Node(0, null);
        Node p = node;
        for (int i = 1; i < 30; i ++) {
            p.next = new Node(i, null);
            p = p.next;
        }
        return node;
    }


    public static Node searchMiddle(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node low = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        return low;
    }


    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node pre = null;
        Node p = node;
        Node q = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = pre;
            pre = q;
        }
        return q;

    }

    public static void main(String[] args) {
        Node node = createNode(new int[3]);
        node.print();
        node =reverse(node);
        node.print();
    }

    public static Node threePartition(Node node, int data) {
        if (node == null || node.next == null) {
            return node;
        }

        Node sh = null;
        Node sl = null;
        Node ml = null;
        Node mh = null;
        Node bl = null;
        Node bh = null;

        Node p = node;

        while (p != null) {
            Node q = p.next;
            if (p.value > data) {
                if (bh == null) {
                    bh = p;
                    bh.next = bl;
                } else {
                    if (bl == null) {
                        bl = p;
                    } else {
                        bl.next = p;
                    }
                }
            } else if (p.value == data){
                if (mh == null) {
                    mh = p;
                    mh.next = ml;
                } else {
                    if (bl == null) {
                        ml = p;
                    } else {
                        ml.next = p;
                    }
                }
            } else {
                if (sh == null) {
                    sh = p;
                    sh.next = sl;
                } else {
                    if (sl == null) {
                        sl = p;
                    } else {
                        sl.next = p;
                    }
                }
            }
            p.next = null;
            p = q;
        }

        if (sl == null) {

        }


        return sh;
    }


    public static Node groupReverse(Node node, int k) {
        if (k <= 0 || node == null) {
            return null;
        }

        return null;


    }


}
