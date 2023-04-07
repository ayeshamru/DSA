package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBT {

    Node root;


    class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
        }
    }

    void createTree(){
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
    }

    void deleteNode(int data){

        if(root.left == null && root.right == null){
            root = null;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Node bckp = null;
        Node parent = null;
        Node temp = null;
        q.add(root);

        while(!q.isEmpty()) {
            temp = q.remove();
            if (temp.data == data) {
                bckp = temp;
            }
            if (temp.left != null) {
                parent = temp;
                q.add(temp.left);
            }
            if (temp.right != null) {
                parent = temp;
                q.add(temp.right);
            }
        }

        bckp.data=temp.data;

            if (parent.left == temp) {
                parent.left = null;
            } else if (parent.right == temp) {
                parent.right = null;
            }


    }

    void displayLevelOrderTraversal(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;

        while(!q.isEmpty() && root != null){
            temp = q.poll();
            System.out.print(temp.data+" | ");
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }

    }
    public static void main(String[] args) {
        DeletionInBT tree = new DeletionInBT();
        tree.createTree();
        tree.displayLevelOrderTraversal();
        System.out.println();
        tree.deleteNode(20);
        tree.displayLevelOrderTraversal();
    }
}
