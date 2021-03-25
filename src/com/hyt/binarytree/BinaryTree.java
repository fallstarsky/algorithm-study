package com.hyt.binarytree;

import java.util.*;

/**
 * @author houyutao
 * @date 2021-03-24
 */
public class BinaryTree {


    /**
     * 创建二叉树,返回根节点
     * @return
     */
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

    /**
     * 非递归前续遍历
     * @param node
     */
    public void preWithStack(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            final Node cur = stack.pop();
            System.out.println(cur.data);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    /**
     * 非递归中续遍历
     * @param node
     */
    public void inWithStack(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                final Node pop = stack.pop();
                System.out.println(pop.data);
                node = pop.right;
            }
        }

    }

    /**
     * 非递归后续遍历
     * @param node
     */
    public void postWithStack(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node pre = null;

        while (!stack.isEmpty()) {
            final Node peek = stack.peek();
            if (peek.left != null && peek.left != pre && peek.right != pre) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != pre) {
                stack.push(peek.right);
            } else {
                pre = stack.pop();
                System.out.println(pre.data);

            }
        }
    }


    /**
     * 层级遍历
     * @param node
     */
    public void level(Node node) {
        if (node == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            final Node cur = queue.poll();
            System.out.println(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 使用map求最大宽度
     * @param node
     * @return
     */
    public int maxWidthWithMap(Node node) {
        if (node == null) {
            return 0;
        }

        LinkedList<Node> queue = new LinkedList<>();
        Map<Node, Integer> levelMap = new HashMap<>();
        int curLevel = 1;
        levelMap.put(node, 1);
        int maxWidth = 0;
        int curLevelNodes = 1;
        queue.add(node);
        while (!queue.isEmpty()) {
            final Node cur = queue.poll();
            int level = levelMap.get(cur);
            if (cur.left != null) {
                queue.add(cur.left);
                levelMap.put(cur.left, level + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                levelMap.put(cur.right, level + 1);
            }

            if (curLevel != level) {
                maxWidth = Math.max(maxWidth, curLevelNodes);
                curLevel ++;
                curLevelNodes = 1;
            } else {
                curLevelNodes ++;
            }
        }

        return Math.max(maxWidth, curLevelNodes);
    }


    /**
     * 不使用Map求最大宽度
     * @param node
     * @return
     */
    public int maxWidthWithNoMap(Node node) {
        if (node == null) {
            return 0;
        }

        LinkedList<Node> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.add(node);
        int curLevelNodes = 1;


        Node curEnd = node;
        Node nextEnd = null;

        while (!queue.isEmpty()) {
            final Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }


            if (cur == curEnd) {
                maxWidth = Math.max(maxWidth, curLevelNodes);
                curEnd = nextEnd;
                curLevelNodes = 1;

            } else {
                curLevelNodes ++;
            }

        }

        return Math.max(maxWidth, curLevelNodes);
    }


    public static void main(String[] args) {
        final Node node = createNode();
        BinaryTree binaryTree = new BinaryTree();
        int i = binaryTree.maxWidthWithNoMap(node);
        System.out.println(i);
    }

}
