package ua.lviv.iot.performances.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.performances.repositories.PerformanceRepository;
import ua.lviv.iot.performances.exception.PerformanceNotFoundException;
import ua.lviv.iot.performances.models.Performance;
import java.util.List;

@Service
@Data
@ApplicationScope
public class PerformanceService {

    private PerformanceRepository repository;

    @Autowired
    public PerformanceService(PerformanceRepository performanceRepository) {
        this.repository = performanceRepository;
    }
    public void addPerformance(Performance performance){
        repository.save(performance);
    }

    public Performance updatePerformance(Integer id, Performance performance) throws PerformanceNotFoundException {
        if (repository.existsById(performance.getId())) {
            performance.setId(id);
            return repository.save(performance);
        }
        throw new PerformanceNotFoundException("Performance with id: " + performance.getId() + "not found");
    }

    public List<Performance> getPerformances(){
        return repository.findAll();
    }

    public Performance getPerformance(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public boolean deletePerformance(Integer id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
