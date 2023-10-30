package com.newshore.apirest.application.controllers.external;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.newshore.apirest.application.controllers.external.dto.FlightApi;
import com.newshore.apirest.application.controllers.external.port.IapiNewShore;

public class apiNewShore implements IapiNewShore{
    RestTemplate restTemplate = new RestTemplate();

    public ArrayList<FlightApi> GetFlightNewShore(){
        ArrayList<FlightApi> listResponse = new ArrayList<FlightApi>();

        try{
            ResponseEntity<FlightApi[]> response = restTemplate.getForEntity("https://recruiting-api.newshore.es/api/flights/1", FlightApi[].class);
            FlightApi[] flights = response.getBody();
            java.util.List<FlightApi> m = Arrays.asList(flights);
            listResponse.addAll(m);
        }
        catch (Exception e){
            e.printStackTrace();   
        }
        
        return listResponse;
    }
}

