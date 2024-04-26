package com.example.traini8Assgn.service;

import com.example.traini8Assgn.entity.TrainingCenter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrainingCenterService {
    ResponseEntity<TrainingCenter> saveTrainingCenter(TrainingCenter trainingCenter);

    TrainingCenter findByCode(String code);

    ResponseEntity<List<TrainingCenter>> findAll();

    ResponseEntity<List<TrainingCenter>> findByCity(String city);

    ResponseEntity<List<TrainingCenter>> findByState(String state);
}
