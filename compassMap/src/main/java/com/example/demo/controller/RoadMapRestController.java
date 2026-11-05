package com.example.demo.controller;

import com.example.demo.model.RoadMap;
import com.example.demo.service.RoadMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/roadmaps")
public class RoadMapRestController {

    @Autowired
    private RoadMapService roadMapService;

    @PostMapping("/create")
    public void createRoadMap() {

    }

    @PutMapping("/byId")
    public void updateById() {

    }

    @GetMapping("/all")  //getAll
    public Iterable<RoadMap> getAllRoadsMaps() {
        // call service to get all roadmaps and return them
        Iterable<RoadMap> roadMaps =  roadMapService.getAllRoadMaps();
        System.out.println("Service getAllRoadMaps: " + roadMaps);
        return roadMaps;
    }

    @GetMapping("/byId")
    public RoadMap getRoadMapById(@RequestParam String id) {
        RoadMap roadMap = roadMapService.getRoadMapById(id);
        System.out.println("Service getRoadMapById: " + roadMap);
        return roadMap;
    }

    @GetMapping("/count")
    public long countRoadMaps() {
        long count = roadMapService.countRoadMaps();
        System.out.println("Service countRoadMaps: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) { roadMapService.deleteRoadMap(id); }

    @DeleteMapping("/all")
    public void deleteAllRoadMaps() { roadMapService.deleteAllRoadMaps(); }
}
