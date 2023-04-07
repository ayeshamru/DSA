package Trees.BinaryTrees;

public class BinaryTreeRecursive {
    Node root;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
        }
    }

    void displayPreOrderTraversal(Node root){

        if(root == null){
            return;
        }
        System.out.print(root.data+" | ");
        displayPreOrderTraversal(root.left);
        displayPreOrderTraversal(root.right);
    }
    void displayInOrderTraversal(Node root){

        if(root == null){
            return;
        }
        displayInOrderTraversal(root.left);
        System.out.print(root.data+" | ");
        displayInOrderTraversal(root.right);
    }

    void displayPostOrderTraversal(Node root){

        if(root == null){
            return;
        }
        displayPostOrderTraversal(root.left);
        displayPostOrderTraversal(root.right);
        System.out.print(root.data+" | ");
    }

    void displayLevelOrderTraversal(Node root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            displayCurrentLevel(root,i);
        }
    }
    int height(Node root){

        if(root == null){
            return 0;
        }else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight > rheight){
                return (lheight+1);
            }else{
                return (rheight+1);
            }
        }

    }

    void displayCurrentLevel(Node root,int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data+ " | ");
        }else if(level>1){
            displayCurrentLevel(root.left,level-1);
            displayCurrentLevel(root.right,level-1);
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

    public static void main(String[] args) {
        BinaryTreeRecursive tree = new BinaryTreeRecursive();
        tree.createTree();
        tree.displayPreOrderTraversal(tree.root);
        System.out.println();
        tree.displayInOrderTraversal(tree.root);
        System.out.println();
        tree.displayPostOrderTraversal(tree.root);
        System.out.println();
        tree.displayLevelOrderTraversal(tree.root);

    }
}
