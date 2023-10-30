package com.newshore.apirest.application.controllers.external.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class JourneyRequest {
    public String origin;
    public String destination;
}
