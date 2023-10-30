package com.newshore.apirest.dataAccess.entities;


import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@AllArgsConstructor
@NoArgsConstructor
@Entity 

public class Transport {
    @Id 
    @GeneratedValue 
    private Integer id;
    @Basic
    private String flightCarrier;
    private String flightNumber;
}
