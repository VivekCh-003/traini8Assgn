package com.example.traini8Assgn.repository;

import com.example.traini8Assgn.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long> {
    TrainingCenter findByCenterCode(String code);

    @Query("SELECT tc FROM TrainingCenter tc WHERE tc.address.city = :city")
    List<TrainingCenter> findByCity(String city);

    @Query("SELECT tc FROM TrainingCenter tc WHERE tc.address.state = :state")
    List<TrainingCenter> findByState(String state);
}
