package com.hyt.binarytree;

/**
 * @desc 二叉树公共祖先问题
 * @author houyutao
 * @date 2021-03-25
 */
public class CommonAncestorProblem {


    public static void main(String[] args) {
        CommonAncestorProblem commonAncestorProblem  = new CommonAncestorProblem();
        final Node node = NodeUtils.create();
        Node a =  node.right.left;
        Node b =  node.left;
        final Node commonAncestor = commonAncestorProblem.getCommonAncestor(node, a, b);
        System.out.println(commonAncestor.data);

    }

    /**
     * 查询两个节点的最初公共祖先
     * @param node 根节点
     * @param a 节点a
     * @param b 节点b
     * @return 节点a 和 节点b 的最初公共节点
     */
    public Node getCommonAncestor(Node node, Node a, Node b) {
        if (node == null || a == null || b == null) {
            return null;
        }
        final NodeInfo nodeInfo = commonAncestor(node, a, b);
        return nodeInfo.node;

    }

    public NodeInfo commonAncestor(Node node, Node a, Node b) {
        if (node == null) {
            return new NodeInfo(false, false, null);
        }
        NodeInfo leftInfo = commonAncestor(node.left ,a, b);
        NodeInfo rightInfo = commonAncestor(node.right, a, b);
        if (leftInfo.containsA && leftInfo.containsB) {
            return leftInfo;
        }
        if (rightInfo.containsA && rightInfo.containsB) {
            return rightInfo;
        }
        boolean containsA = node == a || leftInfo.containsA || rightInfo.containsA;
        boolean containsB = node == b || leftInfo.containsB || rightInfo.containsB;
        Node ancestor = null;
        if (containsA && containsB) {
            ancestor = node;
        }
        return new NodeInfo(containsA, containsB, ancestor);

    }

    static class NodeInfo {
        public boolean containsA;
        public boolean containsB;
        public Node node;

        public NodeInfo(boolean containsA, boolean containsB, Node node) {
            this.containsA = containsA;
            this.containsB = containsB;
            this.node = node;
        }

    }
}
