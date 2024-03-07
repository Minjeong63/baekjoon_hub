import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] binaryTree = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            binaryTree[i] = new Node();
        }
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            char value = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            binaryTree[value - 'A' + 1].value = value;
            if (left != '.') {
                binaryTree[value - 'A' + 1].left = binaryTree[left - 'A' + 1];
            }
            if (right != '.') {
                binaryTree[value - 'A' + 1].right = binaryTree[right - 'A' + 1];
            }

        }

        preorder(binaryTree[1]);
        System.out.println();
        inorder(binaryTree[1]);
        System.out.println();
        postorder(binaryTree[1]);
    }

    static void preorder(Node node) {
        System.out.print(node.value);
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    static void inorder(Node node) {
        if (node.left != null) {
            inorder(node.left);
        }
        System.out.print(node.value);
        if (node.right != null) {
            inorder(node.right);
        }
    }

    static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        System.out.print(node.value);
    }

    static class Node {
        char value;
        Node left;
        Node right;
    }
}