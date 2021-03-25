package com.hyt.binarytree;

/**
 * @author houyutao
 * @date 2021-03-25
 */
public class SuccessorProblem {

    /**
     * 查找当前节点的后继节点
     * @param node
     * @return
     */
    public static NodeWithParent getSuccessor(NodeWithParent node) {
        if (node == null) {
            return null;
        }
        //如果存在右树，则找右树最左
        if (node.right != null) {
            NodeWithParent p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            //如果不存在右树，则找第一个node.parent.left = node;
            NodeWithParent parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }



    /**
     * 查找当前节点的后继节点
     * @param node
     * @return
     */
    public static NodeWithParent getPrecursor(NodeWithParent node) {
        if (node == null) {
            return null;
        }
        //如果存在左树，则找左树最右
        if (node.left != null) {
            NodeWithParent p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else {
            //如果不存在右树，则找第一个node.parent.right = node;
            NodeWithParent parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }


    public static void main(String[] args) {
        final NodeWithParent node = NodeWithParent.create();
//        NodeWithParent successor = getSuccessor(node.right.right);
        NodeWithParent precursor = getPrecursor(node);
        if (precursor != null) {
            System.out.println(precursor.data);
        } else {
            System.out.println(precursor);
        }

    }
}
