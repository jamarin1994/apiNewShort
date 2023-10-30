package com.newshore.apirest.dataAccess.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newshore.apirest.dataAccess.entities.Journey;

@Repository
public interface JourneyRepository extends JpaRepository <Journey, Integer> {
    
}
