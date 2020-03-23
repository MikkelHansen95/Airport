package dk.cphbusiness.airport.template;

import static dk.cphbusiness.airport.template.Category.*;
import dk.cphbusiness.algorithm.examples.queues.NotPrioritisingPassengerArrayQueue;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueue;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueuePassengers;
import java.util.ArrayList;
import java.util.List;

public class Program {
  private static List<Plane> planes = new ArrayList<>();
  private static PassengerProducer producer;
  private static PassengerConsumer consumer;
  private static PassengerConsumer consumer1;
  private static PriorityQueuePassengers queue;
  private static Clock clock;
  
  private static void setup() {
    for (int hour = 7; hour <= 22; hour++) {
      planes.add(new Plane(new Time(hour, 00, 00)));
      }
    queue = new PriorityQueuePassengers();
    /*
    PassengerFactory pasFac = new PassengerFactory();
    List<Passenger> passengers = pasFac.createListOfPassengers(planes.get(0));
    for (int i = 0; i < passengers.size(); i++) {
        queue.enqueue(passengers.get(i));
    }
    */
    
    producer = new PassengerProducer(planes, queue);
    consumer = new PassengerConsumer(planes, queue,"1");
    consumer1 = new PassengerConsumer(planes, queue,"2");
    clock = new Clock(producer, consumer, consumer1, new Time(05, 00, 00));
    }
  
  public static void main(String[] args) {
    setup();
    new Thread(clock).start();
    /*
      System.out.println(LateToFlight.compareTo(Monkey));
      System.out.println(LateToFlight.compareTo(BusinessClass));
      System.out.println(LateToFlight.compareTo(Disabled));
      System.out.println(LateToFlight.compareTo(Family));
      System.out.println(LateToFlight.compareTo(LateToFlight));
      */

    }
  
  }
