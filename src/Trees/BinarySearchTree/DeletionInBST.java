package Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBST {

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
        DeletionInBST tree = new DeletionInBST();
        tree.createTree();
        tree.displayLevelOrderTraversal();

    }

}
