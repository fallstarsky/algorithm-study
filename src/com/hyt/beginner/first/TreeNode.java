package com.hyt.beginner.first;

/**
 * @author houyutao
 * @date 2021-02-01
 */
public class TreeNode implements SeventhClass {

    private int value;
    private TreeNode leftNode;
    private TreeNode rightNode;


    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    static class Info {
        boolean isBalance;
        int high;
        Info(boolean isBalance, int high) {
            this.isBalance = isBalance;
            this.high = high;
        }
    }


    public boolean isBalance(TreeNode root) {
        Info info = getNodeInfo(root);
        return info.isBalance;
    }


    public Info getNodeInfo(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftNodeInfo = getNodeInfo(root.leftNode);
        Info rightNodeInfo = getNodeInfo(root.rightNode);
        if (!leftNodeInfo.isBalance || rightNodeInfo.isBalance || Math.abs(leftNodeInfo.high - rightNodeInfo.high) > 1) {
            return new Info(false, Math.max(leftNodeInfo.high, rightNodeInfo.high) + 1);
        }
        return new Info(true, Math.max(leftNodeInfo.high, rightNodeInfo.high) + 1);

    }


    public static TreeNode  createTree(int[] data) {
        TreeNode root = new TreeNode(data[0], null, null);
        for (int i = 0 ; i < data.length ; i ++) {
            searchPosition(root, data[i]);
        }
        return root;
    }

    private static void searchPosition(TreeNode root, int data) {
        if (data > root.value) {
            if (root.rightNode == null) {
                root.rightNode= new TreeNode(data, null, null);
            } else {
                searchPosition(root.rightNode, data);
            }
        } else {
            if (root.leftNode == null) {
                root.leftNode = new TreeNode(data, null, null);
            } else {
                searchPosition(root.leftNode, data);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.leftNode);
            System.out.print(root.value + ",");
            inOrder(root.rightNode);
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + ",");
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.leftNode);
            postOrder(root.rightNode);
            System.out.print(root.value + ",");
        }
    }

    public static void level(TreeNode root) {
        TreeNode[] queue = new TreeNode[10000];
        int front = 0;
        int rear = 0;

        if (root != null) {
            queue[rear++] = root;
        }

        while (front != rear) {
            TreeNode temp = queue[front++];
            System.out.print(temp.value + ",");
            if (temp.leftNode != null) {
                queue[rear++] = temp.leftNode;
            }
            if (temp.rightNode != null) {
                queue[rear++] = temp.rightNode;
            }
        }
    }


    public static void main(String[] args) {
        int size= 100;
        int[] data = new int[size];
        for (int i = 0 ; i < size ; i ++) {
            data[i] = (int) (Math.random() * size);
            System.out.print(data[i] + ",");
            if (i % 5 == 0 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
        TreeNode root = createTree(data);
        inOrder(root);
    }


}
