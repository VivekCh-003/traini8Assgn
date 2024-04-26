package com.example.traini8Assgn.controller;

import com.example.traini8Assgn.entity.TrainingCenter;
import com.example.traini8Assgn.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService trainingCenterService;

//    save new training center
    @PostMapping("/saveTrainingCenter")
    public ResponseEntity<TrainingCenter> saveTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
        return trainingCenterService.saveTrainingCenter(trainingCenter);
    }

//    get all training centers
    @GetMapping("/findAll")
    public ResponseEntity<List<TrainingCenter>> findAll(){
        return trainingCenterService.findAll();
    }

//    get training center details by center code
    @GetMapping("/findByCenterCode/{code}")
    public ResponseEntity<TrainingCenter> findByCode(@PathVariable String code){
        return ResponseEntity.ok(trainingCenterService.findByCode(code));
    }

//    get training centers from a particular city
    @GetMapping("/findByCity/{city}")
    public ResponseEntity<List<TrainingCenter>> findByCity(@PathVariable String city){
        return trainingCenterService.findByCity(city);
    }

//    get training centers by state
    @GetMapping("/findByState/{state}")
    public ResponseEntity<List<TrainingCenter>> findByState(@PathVariable String state){
        return trainingCenterService.findByState(state);
    }
}
