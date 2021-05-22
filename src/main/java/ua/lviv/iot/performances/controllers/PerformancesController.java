package ua.lviv.iot.performances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.performances.models.Performance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.performances.service.PerformanceService;

import java.util.*;

@RequestMapping("/performance")
@RestController
public class PerformancesController {

    private final PerformanceService performanceService;

    @Autowired
    public PerformancesController(PerformanceService performanceService){
        this.performanceService = performanceService;
    }

    @PostMapping
    public ResponseEntity<Performance> addPerformances(@RequestBody Performance performance){
        return ResponseEntity.ok(performanceService.addPerformance(performance));
    }

    @GetMapping
    public ResponseEntity<Collection<Performance>> getPerformances(){
        return ResponseEntity.ok(performanceService.getPerformances());
    }

    @GetMapping("{id}")
    public ResponseEntity<Performance> getPerformance(@PathVariable("id") int id) {
        Performance performance = performanceService.getPerformance(id);
        if (performance != null)
            return ResponseEntity.ok(performance);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Performance> updatePerformance(@RequestBody Performance newPerformance, @PathVariable("id") int id){
        Performance performance = performanceService.updatePerformance(newPerformance, id);
        if(performance != null)
            return ResponseEntity.ok(performance);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletePerformance(@PathVariable("id") int id){
        int performanceId = performanceService.deletePerformance(id);
        if(performanceId != -1) {
            return ResponseEntity.ok(Collections.singletonMap("id", performanceId));
        }
        return ResponseEntity.notFound().build();
    }
}