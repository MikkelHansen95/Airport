package dk.cphbusiness.airport.template;

import dk.cphbusiness.algorithm.examples.queues.PriorityQueue;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueuePassengers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PassengerProducer {
  private static int nextPassengerId = 1;
  private final List<Plane> planes;
  private final PriorityQueuePassengers queue;
  private int processingTicksLeft = 0;
  private Random randomizer = new Random();
  private Time lastDeartureTime;
  
  public PassengerProducer(List<Plane> planes, PriorityQueuePassengers queue) {
    this.planes = planes;
    this.queue = queue;
    lastDeartureTime = planes.get(planes.size() - 1).getDepartureTime();
    }
  
  public void tick(Clock clock) {
    if (processingTicksLeft > 0) {
      processingTicksLeft--;
      return;
      }
    Time now = clock.getTime();
    if (now.compareTo(lastDeartureTime) >= 0) {
      clock.stop();
      return;
      }
    Plane plane = null;
    while (plane == null) {
      for (Plane p : planes) {
        if (p.getDepartureTime().compareTo(now) < 0) continue;
        if (randomizer.nextInt(3) == 0) {
          plane = p;
          break;
          }
        }
      }
    
    int c = randomizer.nextInt(100);
    Category category;
    if (plane.getDepartureTime().getMillis() - now.getMillis() < 15*60*1000)
        category = Category.LateToFlight;
    else if (c < 25) category = Category.BusinessClass;
    else if (c < 35) category = Category.Disabled;
    else if (c < 90) category = Category.Family;
    else category = Category.Monkey;
    
    Passenger passenger = new Passenger(nextPassengerId++, now, category, plane);
    
    queue.enqueue(passenger);
    System.out.println("Producer:     ->      Passenger "+passenger+" added to queue");

    processingTicksLeft = randomizer.nextInt(120);
    //processingTicksLeft = 100;
    }
  
  
  }
