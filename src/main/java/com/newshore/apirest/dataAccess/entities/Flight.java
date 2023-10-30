package com.newshore.apirest.dataAccess.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // genera los set y get
@AllArgsConstructor// constructores
@NoArgsConstructor// contructores que no reciben parametros
@Entity // mapiar para base de datos

public class Flight {
    @Id // identificar
    @GeneratedValue // como queremes que se genere el valor
    private Integer id;
    @Basic
    private String origin;
    private String destination;
    private Double price;
    
    @OneToOne
    private Transport transport; 


    
}
