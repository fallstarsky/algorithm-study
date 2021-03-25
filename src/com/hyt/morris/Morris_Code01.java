package com.hyt.morris;

import com.hyt.binarytree.Node;

import java.util.Stack;

/**
 * @author houyutao
 * @date 2021-03-24
 */
public class Morris_Code01 {

    public static void main(String[] args) {
        Node node = createNode();
        morris(node);
        System.out.println(isBST(node));
        inOrder(node);

    }



    public static Node createBSTNode() {
        Node node = new Node(5);
        node.left = new Node(2);
        node.right = new Node(9);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
//        node.right.left = new Node(8);
        node.right.right = new Node(1);

        return node;
    }

    public static Node createNode() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        return node;
    }

    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }


    public static void morris(Node node) {
        if (node == null) {
            return;
        }

        Node cur = node;
        Node mostRight = null;

        while (true) {
//            if (cur != null) {
//                System.out.println(cur.data);
//            } else {
//                break;
//            }
            if (cur == null) {
                break;
            }
            if (cur.left == null) {
//                System.out.println(cur.data);
                cur = cur.right;
            } else {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    //前序
//                    System.out.println(cur.data);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    //后序遍历
                    printRightEdge(cur.left);
                    cur = cur.right;

                }
            }

        }
        //后续遍历
        printRightEdge(node);
    }

    /**
     * print right edge
     * @param cur
     */
    private static void printRightEdge(Node cur) {
//        System.out.println(cur.data);
        Node tail = reverse(cur);
        Node p = tail;
        while (p != null) {
            System.out.println(p.data);
            p = p.right;
        }

        reverse(tail);

//
//        Node mostRight = cur;
//        Stack<Node> stack = new Stack<>();
//        stack.push(mostRight);
//        while (mostRight.right != null) {
//            mostRight = mostRight.right;
//            stack.push(mostRight);
//        }
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop().data);
//        }
    }

    private static Node reverse(Node cur) {
        Node pre = null;
        Node p = cur;
        if (p.right == null) {
            return p;
        }

        while (p.right != null) {
            Node q = p.right;
            p.right = pre;
            pre = p;
            p = q;
        }


        p.right = pre;

        return p;
    }

    public static boolean isBST(Node node) {
        if (node == null) {
            return false;
        }

        Node cur = node;
        Node mostRight = null;

        while (true) {
//            if (cur != null) {
//                System.out.println(cur.data);
//            } else {
//                break;
//            }
            if (cur == null) {
                break;
            }
            if (cur.left == null) {
//                System.out.println(cur.data);
                if (cur.right != null) {
                    if (cur.data > cur.right.data) {
                        return false;
                    }
                }

                cur = cur.right;

            } else {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    //前序
//                    System.out.println(cur.data);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    //后序遍历
//                    printRightEdge(cur.left);
                    if (cur.right != null) {
                        if (cur.data > cur.right.data) {
                            return false;
                        }
                    }
                    cur = cur.right;

                }
            }

        }

        return true;
        //后续遍历
//        printRightEdge(node);
    }
}
