package com.hyt.binarytree;

/**
 * @desc 二叉树的相关题目
 * @author houyutao
 * @date 2021-03-25
 */
public class BinaryTreeDistanceProblem {

    public static void main(String[] args) {
        BinaryTreeDistanceProblem binaryTreeDistanceProblem = new BinaryTreeDistanceProblem();
        final Node node = binaryTreeDistanceProblem.create();
        final int i = binaryTreeDistanceProblem.maxDistance(node);
        System.out.println(i);
    }

    /**
     *  创建二叉树
     */
    public Node create() {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);


        node.left.left.left = new Node(4);
        node.left.left.left.left = new Node(4);
        node.left.right.right = new Node(5);

        return node;
    }

    /**
     * 求二叉树中最大距离
     * @param node node
     * @return
     */
    public int maxDistance(Node node) {
        DistanceInfo info = getMaxDistance(node);
        return info.distance;
    }
    private DistanceInfo getMaxDistance(Node node) {
        if (node == null) {
            //如果当前节点为null，则认为高度为0， 最大距离为0
            return new DistanceInfo(0, 0);
        }

        DistanceInfo leftInfo = getMaxDistance(node.left);
        DistanceInfo rightInfo = getMaxDistance(node.right);

        int distance = Math.max(leftInfo.height + 1 + rightInfo.height, Math.max(leftInfo.distance, rightInfo.distance));
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new DistanceInfo(distance, height);
    }

    static class DistanceInfo {
        //当前二叉树的最大距离
        public int distance;
        //二叉树的高度
        public int height;

        public DistanceInfo(int distance, int height) {
            this.distance = distance;
            this.height = height;
        }
    }
}
