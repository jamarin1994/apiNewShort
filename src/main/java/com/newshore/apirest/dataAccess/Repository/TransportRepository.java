package com.newshore.apirest.dataAccess.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newshore.apirest.dataAccess.entities.Transport;


@Repository
public interface TransportRepository extends JpaRepository <Transport, Integer> {
    
}
