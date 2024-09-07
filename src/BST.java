import java.util.*;

public class BST {
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
    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if(root.data > value) {
            root.left = insert(root.left, value);
        }
        if(root.data < value) {
            root.right = insert(root.right, value);
        }
        return root;
        }
        public static Node insert1(Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }
        if(root.data > value) {
            root.left = insert1(root.left, value);
        }
        if(root.data < value) {
            root.right = insert1(root.right, value);
        }
        return root;
        }
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(key < root.data) {
            return search(root.left, key);
        }
        else if(key > root.data) {
            return search(root.right, key);
        }
        else if(root.data == key) {
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean search1(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return search1(root.left, key);
        }
        else if(root.data< key ) {
            return search1(root.right, key);
        }
        else{
            return true;
        }
    }

    public static void inorder_traversal(Node root) {
        if(root == null) {
            return;
        }
        inorder_traversal(root.left);
        System.out.println(root.data + " ");
        inorder_traversal(root.right);
    }

    public static void printinrange(Node root,int X, int Y) {
        if(root == null) {
            return;
        }
        if(root.data >= X && root.data <= Y) {
            printinrange(root.left, X, Y);
            System.out.print(root.data + " ");
            printinrange(root.right, X, Y);
        }
        else if(root.data >= Y) {
            printinrange(root.left, X, Y);
        }
        else {
            printinrange(root.right, X, Y);
        }
    }
    public static void printarraylist(ArrayList<Node> arr) {
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).data);
        }
        System.out.println();
    }
    public static void print2path(Node root, ArrayList<Node> arr) {
        if(root == null) {
            return;
        }
        arr.add(root);
        if(root.left == null && root.right == null) {//leaf case
            printarraylist(arr);
        } else {
            print2path(root.left, arr);
            print2path(root.right, arr);
        }

        arr.remove(arr.size()-1);
    }
     public static Node delete(Node root, int value) {
        if(root == null) {
            return null;
        }
        if(root.data > value ) {
            root.left = delete(root.left, value);
        }
        else if (root.data < value) {
            root.right = delete(root.right, value);
        }
        else {//root.data = value
            if(root.right == null && root.left == null) {//if it is a leaf node
                return null;
            }
            else if(root.right == null) {
                return root.left;
            }
            else if(root.left == null) {
                return root.right;
            }
            else {
                Node IS = inordersuccessor(root);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
                //return IS.right;
            }
        }
        return root;
     }
     public static Node inordersuccessor(Node root) {
        while(root.left != null) {
            root = inordersuccessor(root.left);
        }
        return root;
     }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        //inorder_traversal(root);
        //boolean a = search1(root, 6);
        //System.out.println(a);
        //printinrange(root, 5, 9);
        //ArrayList<Node> arr = new ArrayList<>();
        //print2path(root, arr);
        delete(root, 1);
        inorder_traversal(root);

    }
}
