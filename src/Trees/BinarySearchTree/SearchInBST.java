package Trees.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBST {

  Node root;
  Node temp;

  Boolean found = false;

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

    void searchElementIterative(int element){
        temp = root;

        while(temp != null) {
            if (element < temp.data) {
                temp = temp.left;
            } else if (element > temp.data) {
                temp = temp.right;
            } else if (element == temp.data) {
                System.out.println("Element Found !");
                return;
            }
        }
        System.out.println("Element not Found !");

    }

    void searchElementRecursive(Node root,int element){
        if(root == null){
            return;
        }
        if(element < root.data){
            searchElementRecursive(root.left,element);
        }
        if(element > root.data){
            searchElementRecursive(root.right,element);
        }
        if(element == root.data) {
            found = true;
            return;
        }
    }

    public static void main(String[] args) {
        SearchInBST tree = new SearchInBST();
        tree.createTree();
        tree.displayLevelOrderTraversal();
//        System.out.println();
//        tree.searchElementIterative(120);
        System.out.println();
        tree.searchElementRecursive(tree.root,100);
        if(tree.found == true){
            System.out.println("Element found");
        }else{
            System.out.println("Element not found");
        }

    }
}
