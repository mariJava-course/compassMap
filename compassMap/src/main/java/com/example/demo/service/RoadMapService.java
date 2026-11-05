package com.example.demo.service;

import com.example.demo.model.RoadMap;
import com.example.demo.repository.RoadMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoadMapService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private RoadMapRepository roadMapRepository;

    public Iterable<RoadMap> getAllRoadMaps() {
        return roadMapRepository.findAll();
    }

    public RoadMap createRoadMap (RoadMap roadMap){
        // SET ID roadMap to UUID
        roadMap.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        RoadMap createdRoadMap = roadMapRepository.save(roadMap);
        System.out.println("Service created roadMap: " +  createdRoadMap);
        return createdRoadMap;
    }

    public void deleteRoadMap (String id){
      roadMapRepository.deleteById(id);

    }

    public RoadMap getRoadMapById(String id){
        Optional<RoadMap> foundRoadMap = roadMapRepository.findById(id);
        return foundRoadMap.orElse(null);
    }

    public void saveAll(ArrayList<RoadMap> roadMaps) {
        roadMapRepository.saveAll(roadMaps);
    }

    public void deleteAllRoadMaps() { roadMapRepository.deleteAll();}

    public long countRoadMaps() {
        return roadMapRepository.count();
    }

}
