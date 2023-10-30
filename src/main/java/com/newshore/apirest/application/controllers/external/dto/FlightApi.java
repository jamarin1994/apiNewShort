package com.newshore.apirest.application.controllers.external.dto;

import lombok.Data;

@Data
public class FlightApi {
    public String departureStation;
    public String arrivalStation;
    public String flightCarrier;
    public String flightNumber;
    public Double price;
}
