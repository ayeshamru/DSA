package Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionInBST {

    Node root;
    Node temp;

    class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
        }
    }

    void insertIteratively(int data){
        Node bckp = null;
        temp = root;

        while(temp != null ) {
            if (data < temp.data) {
                bckp = temp;
                temp = temp.left;
            } else if (data > temp.data) {
                bckp = temp;
                temp = temp.right;
            }
        }
        if(data < bckp.data){
            bckp.left = new Node(data);
        }else if(data > bckp.data){
            bckp.right = new Node(data);
        }
    }

    void insertRecursively(Node root,int data){

    }

    void createTree(){
        root = new Node(100);
        root.left = new Node(20);
        root.right = new Node(500);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.right = new Node(600);
    }

    void displayLevelOrderTraversal(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

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
        InsertionInBST tree = new InsertionInBST();
        tree.createTree();
        tree.displayLevelOrderTraversal();
        System.out.println();
        //tree.insertIteratively(110);
        tree.displayLevelOrderTraversal();
        System.out.println();
        tree.insertRecursively(tree.root,110);
    }
}
