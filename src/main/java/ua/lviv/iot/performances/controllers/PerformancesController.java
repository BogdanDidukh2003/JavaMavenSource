package ua.lviv.iot.performances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import ua.lviv.iot.performances.models.Performance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.performances.service.PerformancesService;

import java.util.*;

@RequestMapping("/performance")
@RestController
public class PerformancesController {

    @Autowired
    private PerformancesService performanceService;

    @GetMapping(path = "/{id}")
    public Performance getPerformance(@PathVariable(name = "id") Integer id) {
        return performanceService.getPerformance(id);
    }

    @GetMapping
    public List<Performance> getPerformance() {
        return performanceService.getPerformance();
    }

    @PutMapping
    public Performance createPerformance(@RequestBody Performance performance) {
        return performanceService.addPerformance(performance);
    }

    @PostMapping
    public ResponseEntity<Performance> updatePerformance(@RequestBody Performance performance) {
        if (performanceService.getPerformance(performance.getId()) != null) {
            return new ResponseEntity<Performance>(performanceService.updatePerformance(performance), HttpStatus.OK);
        } else {
            return new ResponseEntity<Performance>(HttpStatus.NOT_FOUND);
        }
    }
}