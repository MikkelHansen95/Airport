package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author Mikkel
 */
public class PriorityQueuePassengers implements PriorityQueue<Passenger> {

    private Passenger[] items;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added

    public PriorityQueuePassengers(int capacity) {
        //items = (T[])new Object[capacity];
        items = new Passenger[capacity];
    }

    public void enqueue(Passenger item) {
        if (size == items.length) {
            throw new IllegalStateException("Cannot add to full queue");
        }
        items[tail] = item;
        tail = (tail + 1);
        size++;
        this.sort();
    }

    public Passenger dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Passenger item = items[head];
        items[head] = null;
        head = (head + 1);
        size--;
        return item;
    }

    public Passenger peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return items[head];
    }

    public int size() {
        return size;
    }

    public void sort() {
        int size = this.tail;
        for (int i = size / 2 - 1; i >= head; i--) {
            heapify(this.items, size, i);
        }
        for (int i = size - 1; i >= head; i--) {
            Passenger temp = this.items[i];
            Passenger temp0 = this.items[head];
            this.items[i] = temp0;
            this.items[head] = temp;
            heapify(this.items, i, head);
        }
    }

    private void heapify(Passenger[] arr, int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
        // If left child is larger than root 
        if (l < n && arr[l].compareTo(arr[r]) > 0) {
            largest = l;
        }
        // If right child is larger than largest so far 
        if (r < n && arr[r].compareTo(arr[l]) > 0) {
            largest = r;
        }
        // If largest is not root 
        if (largest != i) {
            Passenger swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }

    public void printQueue() {
        for (int i = 0; i < items.length; i++) {
            Passenger item = items[i];
            if (item == null) {
                continue;
            } else {
                System.out.println(item.toString());
            }

        }
    }

}
