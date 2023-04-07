package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;
    int count = 0;

    void displayLevelOrderTraversal(){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp;

        while(!q.isEmpty()){
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

    void displayPreOrderTraversal(){
        Stack<Node> s = new Stack<>();
        s.push(root);
        Node temp ;

       while(!s.isEmpty()){
           temp = s.pop();
           System.out.print(temp.data+" | ");
           if(temp.right != null){
               s.push(temp.right);
           }
           if(temp.left != null){
               s.push(temp.left);
           }
       }

    }

    void displayInOrderTraversal(){
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(!s.isEmpty() || curr != null){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }else{
                curr = s.pop();
                System.out.print(curr.data+ " | ");
                curr = curr.right;
            }
        }

    }

    void displayPostOrderTraversal(){
        Stack<Node> s = new Stack<>();
        s.push(root);
        Stack<Node> op = new Stack<>();
        Node curr;

        while(!s.isEmpty()){
            curr = s.pop();
            op.push(curr);
            if(curr.left != null){
                s.push(curr.left);
            }
            if(curr.right != null){
                s.push(curr.right);
            }

        }
        while(!op.isEmpty()){
            System.out.print(op.peek().data + " | ");
            op.pop();
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


    class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
        }
    }

    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.createTree();
   // tree.displayLevelOrderTraversal();
     //   tree.displayPreOrderTraversal();
      //  tree.displayPostOrderTraversal();
        tree.displayInOrderTraversal();
    }
}
