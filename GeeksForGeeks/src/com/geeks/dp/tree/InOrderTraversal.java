package com.geeks.dp.tree;

import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {

        Node node = SampleDataUtil.getSampleBinaryTree();

        inOrderRecursion(node);
        System.out.println();
        inOrderStack(node);
        System.out.println();
        inOrder(node);

    }

    private static void inOrder(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + ", ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made in the 'if' part to restore the
                    original tree i.e., fix the right child of predecessor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + ", ");
                    current = current.right;
                } /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }

    private static void inOrderStack(Node node) {
        if (null == node)
            return;

        Stack<Node> stack = new Stack<>();
        pushLeftInStack(stack, node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            System.out.print(node.data + ", ");

            pushLeftInStack(stack, node.right);
        }

    }

    private static void pushLeftInStack(Stack<Node> stack, Node node) {
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
    }

    private static void inOrderRecursion(Node node) {

        if (null == node)
            return;
        inOrderRecursion(node.left);
        System.out.print(node.data + ", ");
        inOrderRecursion(node.right);

    }

}
