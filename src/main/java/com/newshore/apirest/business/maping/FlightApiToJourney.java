package com.newshore.apirest.business.maping;

import java.util.ArrayList;

import com.newshore.apirest.application.controllers.external.dto.FlightApi;
import com.newshore.apirest.dataAccess.entities.Flight;
import com.newshore.apirest.dataAccess.entities.Transport;


public class FlightApiToJourney {
    private ArrayList<FlightApi> listFlightResponse;
    
    public FlightApiToJourney(ArrayList<FlightApi> listFlights){
        this.listFlightResponse = listFlights;
        // System.out.println("Dataaa"+listFlightResponse);
    }
    
    public ArrayList<Flight> ProcessFlights(){
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for(FlightApi item : this.listFlightResponse){
            Flight flight = new Flight();
            Transport transport = new Transport();
            
            transport.setFlightCarrier(item.flightCarrier);
            transport.setFlightNumber(item.flightNumber);

            flight.setOrigin(item.departureStation);
            flight.setDestination(item.arrivalStation);
            flight.setPrice(item.price);
            flight.setTransport(transport);
            flights.add(flight);
        }
        return flights;
    }
}
