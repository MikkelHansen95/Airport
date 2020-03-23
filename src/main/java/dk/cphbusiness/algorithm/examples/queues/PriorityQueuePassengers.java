package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;

/**
 * @author Mikkel
 */
public class PriorityQueuePassengers {

    BinarySearchTree bt;  
      
    public PriorityQueuePassengers() {
        bt = new BinarySearchTree();
    }

    public void enqueue(Passenger item) {
        bt.insert(item);
        //System.out.println("P: " + peek());
    }

    public Passenger dequeue() {
     return bt.delete().data; 
    }

    public Passenger peek() {
        return bt.maxNode(bt.root).data;
    }
    
    public void printTree(){
        bt.inorderTraversal(bt.root);
    }


}
