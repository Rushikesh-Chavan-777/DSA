import java.util.*;
import java.util.Queue;

public class BinaryTreesYT {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;
        public static Node buildtree(int nodes[]) {
            idx++;
            if(idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = buildtree(nodes);
            newnode.right = buildtree(nodes);
            return newnode;
        }
        public static void preorder_traversal(Node root) {
            if(root == null) {
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preorder_traversal(root.left);
            preorder_traversal(root.right);

        }
        public static void inorder_traversal(Node root) {
            if(root == null) {
                System.out.print("-1 ");
                return;
            }
            inorder_traversal(root.left);
            System.out.print(root.data + " ");
            inorder_traversal(root.right);
        }
        public static void post_traversal(Node root) {
            if(root == null) {
                System.out.print("-1 ");
                return;
            }
            inorder_traversal(root.left);
            inorder_traversal(root.right);
            System.out.print(root.data + " ");
        }
        public static void levelorder_traversal(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                Node curr = q.remove();
                if(curr != null) {
                    System.out.print(curr.data + " ");
                    if(curr.left != null) {
                        q.add(curr.left);
                    }
                    if(curr.right != null) {
                        q.add(curr.right);
                    }
                }else {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }else {
                        q.add(null);
                    }
                }
            }
        }
        public static boolean isidentical(Node root, Node subroot) {
            if(root == null && subroot == null) {
                return true;
            }
            if(root == null || subroot == null) {
                return false;
            }
            if(root.data == subroot.data) {
                return isidentical(root.right, subroot.right) && isidentical(root.left, subroot.right);
            }
            return false;
        }
        public static boolean issubtree(Node root, Node subroot) {
            if(subroot == null) {
                return true;
            }
            if(root == null) {
                return false;
            }
            if(root.data == subroot.data) {
                return isidentical(root, subroot);
            }
            return issubtree(root.right, subroot) || issubtree(root.left, subroot);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        BinaryTree tree = new BinaryTree();
        Node newnode = tree.buildtree(nodes);
        //System.out.println(newnode.data);
        //tree.preorder_traversal(newnode);
        //tree.inorder_traversal(newnode);
        tree.levelorder_traversal(newnode);
    }
}