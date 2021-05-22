package ua.lviv.iot.performances.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.performances.models.Performance;
import ua.lviv.iot.performances.repository.PerformanceRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PerformanceService {

    @Autowired
    private final PerformanceRepository repository;

    public PerformanceService(PerformanceRepository repository) {
        this.repository = repository;
    }

    public Performance addPerformance(Performance performance){
        repository.save(performance);
        return performance;
    }

    public List<Performance> getPerformances(){
        return StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Performance getPerformance(int id){
        return repository.findById(id).orElse(null);
    }

    public Performance updatePerformance(Performance newPerformance, int performanceId){
        Performance performance = repository.findById(performanceId).orElse(null);
        if(performance != null) {
            performance = performance.copy();
            newPerformance.setId(performanceId);
            repository.save(newPerformance);
        }
        return performance;
    }

    public int deletePerformance(int performanceId){
        Performance penguin = repository.findById(performanceId).orElse(null);
        if(penguin!=null) {
            repository.deleteById(performanceId);
            return performanceId;
        }
        return -1;
    }
}
