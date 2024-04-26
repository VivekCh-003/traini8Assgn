package com.example.traini8Assgn.service;

import com.example.traini8Assgn.entity.TrainingCenter;
import com.example.traini8Assgn.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService{
    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public ResponseEntity<TrainingCenter> saveTrainingCenter(TrainingCenter trainingCenter) {
//        checking whether training center is already present in the database or not
        TrainingCenter temp = findByCode(trainingCenter.getCenterCode());
        if (temp != null && trainingCenter.getCenterCode().equals(temp.getCenterCode())){
            return ResponseEntity.ok(findByCode(trainingCenter.getCenterCode()));
        }

        trainingCenter.setCreatedOn(System.currentTimeMillis()/1000);
        trainingCenterRepository.save(trainingCenter);

        return ResponseEntity.ok(trainingCenter);
    }

    @Override
    public TrainingCenter findByCode(String code) {
        TrainingCenter trainingCenter = trainingCenterRepository.findByCenterCode(code);

        return trainingCenter;
    }

    @Override
    public ResponseEntity<List<TrainingCenter>> findAll() {
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();

        return ResponseEntity.ok(trainingCenters);
    }

    @Override
    public ResponseEntity<List<TrainingCenter>> findByCity(String city) {
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findByCity(city);

        return ResponseEntity.ok(trainingCenters);
    }

    @Override
    public ResponseEntity<List<TrainingCenter>> findByState(String state) {
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findByState(state);

        return ResponseEntity.ok(trainingCenters);
    }
}
