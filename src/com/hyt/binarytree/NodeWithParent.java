package com.hyt.binarytree;

/**
 * @author houyutao
 * @date 2021-03-24
 */
public class NodeWithParent {

    public int data;
    public NodeWithParent left;
    public NodeWithParent right;

    public NodeWithParent parent;

    public NodeWithParent(int data) {
        this.data = data;
    }

    /**
     * 创建二叉树,返回根节点
     * @return
     */
    public static NodeWithParent create() {
        NodeWithParent node = new NodeWithParent(1);

        node.left = new NodeWithParent(2);
        node.right = new NodeWithParent(3);

        node.left.left = new NodeWithParent(4);
        node.left.right = new NodeWithParent(5);
        node.right.left = new NodeWithParent(6);
        node.right.right = new NodeWithParent(7);

        node.left.parent = node;
        node.right.parent = node;

        node.left.left.parent = node.left;
        node.left.right.parent = node.left;
        node.right.left.parent = node.right;
        node.right.right.parent = node.right;


        return node;
    }
}
