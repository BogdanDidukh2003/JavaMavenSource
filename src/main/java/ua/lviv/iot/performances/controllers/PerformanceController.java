package ua.lviv.iot.performances.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.performances.exception.PerformanceNotFoundException;
import ua.lviv.iot.performances.models.Performance;
import ua.lviv.iot.performances.service.PerformanceService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/performance")
public class PerformanceController {

    private static final Logger LOGGER = Logger.getLogger("ua.lviv.iot.shop.controllers.PerformanceController");

    @Autowired
    private PerformanceService performanceService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Performance> getPerformance(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(performanceService.getPerformance(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            LOGGER.severe("Performance with" + id + "id does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Performance> getPerformances(){
        return performanceService.getPerformances();
    }

    @PostMapping
    public ResponseEntity<Performance> createPerformance(@RequestBody Performance performance){
        if (performance.getId() == null) {
            performanceService.addPerformance(performance);
            return new ResponseEntity<Performance>(performance, HttpStatus.OK);
        }
        LOGGER.severe("Failed to create a Performance with passed id. Performance creation should not use external ids");
        return new ResponseEntity<Performance>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Performance> updatePerformance(@PathVariable Integer id, @RequestBody Performance performance){
        try {
            performance.setId(id);
            performanceService.updatePerformance(id, performance);
            return new ResponseEntity<>(performance, HttpStatus.OK);
        } catch (PerformanceNotFoundException e) {
            LOGGER.severe("Can't update an performance with non-existing id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePerformance(@PathVariable Integer id){
        if (performanceService.deletePerformance(id)){
            return ResponseEntity.ok("Successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
