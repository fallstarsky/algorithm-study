package com.hyt;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author houyutao
 * @date 2021-03-29
 */
public class UnionFind<V> {

    private HashMap<V, Node<V>> nodes = new HashMap<>();

    private HashMap<Node<V>, Integer> sizeMap = new HashMap<>();

    private HashMap<Node<V>, Node<V>> parents = new HashMap<>();


    static class Node<V>{
        V value;
        public Node(V value) {
            this.value = value;
        }
    }


    public UnionFind(V[] data) {
        for (int i = 0 ; i < data.length ; i ++) {
            Node node = new Node(data[i]);
            nodes.put(data[i], node);
            sizeMap.put(node, 1);
            parents.put(node, node);
        }
    }

    public Node findParent(Node node) {
        Stack<Node> stack = new Stack<>();
        while (parents.get(node) != node) {
            stack.push(node);
            node = parents.get(node);
        }

        while (!stack.isEmpty()) {
            final Node popNode = stack.pop();
            parents.put(popNode, node);
        }

        return node;
    }

    public boolean isSameSet(V a, V b) {
        return findParent(nodes.get(a)) == findParent(nodes.get(b));

    }

    public void union(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return;
        }

        if (isSameSet(a, b)) {
            return;
        }

         Node<V> aNode = nodes.get(a);
         Node<V> bNode = nodes.get(b);

         int aSize = sizeMap.get(aNode);
         int bSize = sizeMap.get(bNode);

         if (aSize < bSize) {
             bSize += aSize;
             sizeMap.put(bNode, bSize);
             parents.put(bNode, aNode);
         } else {
             aSize += bSize;
             sizeMap.put(aNode, aSize);
             parents.put(aNode, bNode);
         }


    }


    public static void main(String[] args) {
        Integer[] data = new Integer[10];
        for (int i = 0 ; i < data.length ; i ++) {
            data[i] = i;
        }

        UnionFind<Integer> unionFind = new UnionFind<Integer>(data);

        System.out.println(unionFind.isSameSet(1,2));
        unionFind.union(1,2);
        System.out.println(unionFind.isSameSet(1,2));


        System.out.println(unionFind.isSameSet(1,3));

        unionFind.union(3,2);

        System.out.println(unionFind.isSameSet(1,2));


    }


}
