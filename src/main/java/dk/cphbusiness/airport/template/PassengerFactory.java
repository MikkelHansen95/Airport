/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.airport.template;

import static dk.cphbusiness.airport.template.Category.BusinessClass;
import static dk.cphbusiness.airport.template.Category.Disabled;
import static dk.cphbusiness.airport.template.Category.*;
import dk.cphbusiness.algorithm.examples.queues.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mikkel
 */
public class PassengerFactory {

    List<Passenger> passengers = new ArrayList();

    public List<Passenger> createListOfPassengers( Plane plane) {

        Passenger pas1 = new Passenger(1, new Time(9, 37, 5), LateToFlight, plane);
        Passenger pas2 = new Passenger(2, new Time(9, 39, 5), BusinessClass, plane);
        Passenger pas3 = new Passenger(3, new Time(9, 38, 5), BusinessClass, plane);
        Passenger pas4 = new Passenger(4, new Time(10, 15, 5), Disabled, plane);
        Passenger pas5 = new Passenger(5, new Time(8, 15, 5), LateToFlight, plane);
        Passenger pas6 = new Passenger(6, new Time(8, 19, 5), Family, plane);
        Passenger pas7 = new Passenger(7, new Time(8, 15, 5), Monkey, plane);
        Passenger pas8 = new Passenger(8, new Time(8, 15, 5), BusinessClass, plane);
        Passenger pas9 = new Passenger(9, new Time(8, 14, 5), LateToFlight, plane);
        Passenger pas10 = new Passenger(10, new Time(8, 15, 5), Family, plane);
        Passenger pas11 = new Passenger(11, new Time(8, 16, 5), LateToFlight, plane);
        Passenger pas12 = new Passenger(12, new Time(8, 20, 5), Family , plane);
        Passenger pas13 = new Passenger(13, new Time(8, 17, 5), LateToFlight, plane);
        

        passengers.add(pas1);
        passengers.add(pas2);
        passengers.add(pas3);
        passengers.add(pas4);
        passengers.add(pas5);
        passengers.add(pas6);
        passengers.add(pas7);
        passengers.add(pas8);
        passengers.add(pas9);
        passengers.add(pas10);
        passengers.add(pas11);
        passengers.add(pas12);
        passengers.add(pas13);
        
        
        
        return passengers;
    }


}
