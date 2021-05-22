package ua.lviv.iot.performances.repository;

import ua.lviv.iot.performances.models.Performance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance, Long> {
}
