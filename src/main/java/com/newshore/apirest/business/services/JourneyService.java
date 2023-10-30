package com.newshore.apirest.business.services;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.newshore.apirest.application.controllers.external.dto.JourneyRequest;
import com.newshore.apirest.dataAccess.Repository.JourneyRepository;
import com.newshore.apirest.dataAccess.entities.Flight;
import com.newshore.apirest.dataAccess.entities.Journey;

import lombok.RequiredArgsConstructor;


@Service //especificamos la anotacion de services
// el servicio va a provver servicios al controlador 
@RequiredArgsConstructor // para la inyeccion de dependecias automaticasval momento de crear el constructor
public class JourneyService {
    // metodos para un crud 
    // creamos el atributo e inicializar nuestro objeto de respositorio tenemos varias formas de inyectarlo
    
    private JourneyRepository journeyRepo;
    private JourneyRequest Request;
    private ArrayList<Flight> Flights;
    public Double PriceJourney = 0.0;

    public JourneyService(JourneyRequest request, ArrayList<Flight> flights){
        this.Request = request;
        this.Flights = flights;
    }

    public void createJourney(Journey journey){
        journeyRepo.save(journey);
    }
    
    public Journey JourneyFinal (){
        Journey journey = new Journey();
        journey.setOrigin(Request.origin); 
        journey.setDestination(Request.destination); 

        ArrayList<Flight> flightsSelected = DirectFlight();
        if (flightsSelected.size() == 0){
            ArrayList<Flight> firstFilter = FirstFlightsFilter(); 
            flightsSelected = TripFlights(firstFilter); 
        }
        journey.setFlights(flightsSelected);  
        journey.setPrice(PriceJourney);
        
        return journey;
    }

    private ArrayList<Flight> DirectFlight(){
        ArrayList<Flight> flightsSelected = new ArrayList<Flight>();
        for (Flight flight : Flights) {
            if(Request.destination.equals(flight.getDestination()) && Request.origin.equals(flight.getOrigin())){
                flightsSelected.add(flight); //Esta condición solo funciona si el vuelo es directo
                PriceJourney = flight.getPrice(); 
                break;
            }
        }
        return flightsSelected;
    }

    private ArrayList<Flight> FirstFlightsFilter(){
        ArrayList<Flight> result = new ArrayList<Flight>();
        for (Flight flight : Flights) {
            if(Request.origin.equals(flight.getOrigin()) || Request.destination.equals(flight.getDestination())){
                result.add(flight);
            }
        }
        return result;
    }
    
    private ArrayList<Flight> TripFlights(ArrayList<Flight> firstList){
        ArrayList<Flight> result = new ArrayList<Flight>();
        boolean stop = false;
        for (Flight flight : firstList) {
            if (result.size() == 0 && !stop){
                for (int i = 1; i <= firstList.size(); i++) {
                    if(flight.getDestination().equals(firstList.get(i).getOrigin())){
                        result.add(flight);
                        break;
                    }
                }
            }
            else if(!stop)
            {
                for (int i = 0; i < result.size(); i++) {
                    if(result.get(i).getDestination().equals(flight.getOrigin())){
                        result.add(flight);
                        stop = true;
                    }
                }
            }
            if (stop){
                break;
            }
        }
        result.forEach((r) -> PriceJourney += r.getPrice());
        return result;
    }

}

