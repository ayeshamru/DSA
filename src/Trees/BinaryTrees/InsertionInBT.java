package Trees.BinaryTrees;

public class InsertionInBT {

    Node root;
    int flag=-1;

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

    void insertLevelOrderTraversal(Node root,int data){
        int h = height(root);
        for(int i=1;i<=h;i++){
            if(flag==-1)
                insertNode(root,i,data);
        }
    }

    void displayLevelOrderTraversal(Node root){
        int h = height(root);
        for(int i=1;i<=h;i++){
            displaycurrentlevel(root,i);
        }
    }

    int height(Node root){
        if(root == null){
            return 0;
        }else{
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight>rheight){
                return (lheight+1);
            }else{
                return (rheight+1);
            }

        }
    }

    void displaycurrentlevel(Node root,int level){
        if(root == null) {
            return;
        }
       if(level == 1){
            System.out.print(root.data+" | ");
        }else if(level >1){
           displaycurrentlevel(root.left,level-1);
           displaycurrentlevel(root.right,level-1);
       }
    }

    void insertNode(Node root,int level,int data){
    if(root == null){
        return;
    }
    if(level >0){

            if(root.left == null && flag==-1){
                Node newNode = new Node(data);
                root.left = newNode;
                flag=1;
                return;
            }
            insertNode(root.left,level-1,data);
            if(root.right == null && flag==-1){
                Node newNode = new Node(data);
                root.right = newNode;
                flag=1;
                return;
            }
            insertNode(root.right,level-1,data);
        }
    }
    public static void main(String[] args) {
        InsertionInBT tree = new InsertionInBT();
        tree.createTree();
        //traverse the tree to find empty pos
        tree.displayLevelOrderTraversal(tree.root);
        System.out.println();
        tree.insertLevelOrderTraversal(tree.root,50);
        System.out.println();
        tree.displayLevelOrderTraversal(tree.root);

    }
}
