package com.newshore.apirest.application.controllers.external.port;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.newshore.apirest.application.controllers.external.dto.FlightApi;

@Repository
public interface IapiNewShore {
    ArrayList<FlightApi> GetFlightNewShore();
}
