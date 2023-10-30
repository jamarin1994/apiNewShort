package com.newshore.apirest.dataAccess.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data   // genera los set y get
@AllArgsConstructor// constructores
@NoArgsConstructor// contructores que no reciben parametros
@Entity // mapiar para base de datos

public class Journey {
    @Id // identificar
    @GeneratedValue // como queremes que se genere el valor
    private Integer id;
    @Basic
    private String origin;
    private String destination;
    private Double price;
    
    @OneToMany
    private List<Flight> Flights; 
    
}
