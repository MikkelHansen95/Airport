package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;

/**
 * @author Mikkel
 */
public class BinarySearchTree {

    //Represent a node of binary tree  
    public static class Node {

        Passenger data;
        Node left;
        Node right;

        public Node(Passenger passenger) {
            //Assign data to the new node, set left and right children to null  
            this.data = passenger;
            this.left = null;
            this.right = null;
        }
    }

    //Represent the root of binary tree  
    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    //insert() will add new node to the binary search tree  
    public void insert(Passenger data) {
        //Create a new node  
        Node newNode = new Node(data);

        //Check whether tree is empty  
        if (root == null) {
            root = newNode;
            return;
        } else {
            //current node point to root of the tree  
            Node current = root, parent = null;

            while (true) {
                //parent keep track of the parent node of current node.  
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree  
                if (data.compareTo(current.data) > 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } //If data is greater than current's data, node will be inserted to the right of tree  
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }


    //minNode() will find out the minimum node  
    public Node minNode(Node root) {
        if (root.left != null) {
            return minNode(root.left);
        } else {
            return root;
        }
    }

    //maxNode() will find out the maximum node  
    public Node maxNode(Node node) {
        if (node.right != null) {
            return maxNode(node.right);
        } else {
            return node;
        }
    }

    //maxNode() will find out the maximum node  
    public Node delete() {

        //Check whether tree is empty  
        if (root == null) {
            return root;
        } else {
            //current node point to root of the tree  
            Node current = root, parent = current;
            Node newNode = null;
            while (true) {
                if (current.right != null) {
                    parent = current;
                    current = current.right;
                } else {
                    newNode = current;
                    if(current.left == null){
                        //System.out.println("parent: " + parent.toString());
                        //System.out.println("current: " + current.toString());
                        parent.right = null;
                    }else{
                        //System.out.println("parent: " + parent.toString());
                        //System.out.println("current: " + current.toString());
                        parent.right = null;
                        parent.right = current.left;
                    }
                    return newNode;
                }
            }
        }
    }


//inorder() will perform inorder traversal on binary search tree  
public void inorderTraversal(Node node) {

        //Check whether tree is empty  
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {

            if (node.left != null) {
                inorderTraversal(node.left);
            }
            System.out.print(node.data + " ");
            if (node.right != null) {
                inorderTraversal(node.right);
            }

        }
    }

}
