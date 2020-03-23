Find API [here](https://rawgit.com/cphbus-algorithms/airport-template/master/target/site/apidocs/index.html)

 1. Create a priority queue instead of the `NotPrioritisingPassengerArrayQueue` used now
 2. Experiment with other values for producer and consumer
 3. Try to add more than one consumer



We have made our solution using Binary Search Tree, which has a O(log n) on insertion, searching and deleting on average.
However the worst case scenario, is that if every passenger shows up in order from the lowest to the highest we will have a O(n), because we will have to go through the whole tree to find the biggest node/the one passenger with the highest priority.
However, this is very unlikely.  

We have added a second consumer, and it only makes the consumers switch between dequeuing the ones with the highest priority.  

We have tried to change the producer and consumer values with different ticking times and it still works fine.
