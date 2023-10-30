package com.newshore.apirest.application.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newshore.apirest.application.controllers.external.apiNewShore;
import com.newshore.apirest.application.controllers.external.dto.FlightApi;
import com.newshore.apirest.application.controllers.external.dto.JourneyRequest;
import com.newshore.apirest.business.maping.FlightApiToJourney;
import com.newshore.apirest.business.services.JourneyService;
import com.newshore.apirest.dataAccess.entities.Flight;
import com.newshore.apirest.dataAccess.entities.Journey;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;


@RestController // lo que va hacer es publicar todos los endpoint que serian las rutas que se ponen a disposicion de los cientes
//para que puedena manipular los datos o exponer una funcionalidad
// @RequestMapping("/journey") //rutas del controlador journey
@RequiredArgsConstructor//para trabajr con el servicio

public class JourneyController {

    private final JourneyService journeyService;
    public apiNewShore portApiNewShore = new apiNewShore();
    
    @PostMapping 
    public void createJourney(@RequestBody Journey journey){
        journeyService.createJourney(journey);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/trips")
    public Journey getMethodName(@RequestBody JourneyRequest request) { 
        ArrayList<FlightApi> apiResponse = portApiNewShore.GetFlightNewShore();
        FlightApiToJourney mappingFlights = new FlightApiToJourney(apiResponse);
        ArrayList<Flight> flights = mappingFlights.ProcessFlights();
        JourneyService service = new JourneyService(request, flights);
        return service.JourneyFinal();
    }    
}
