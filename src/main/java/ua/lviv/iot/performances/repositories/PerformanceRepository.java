package ua.lviv.iot.performances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.performances.models.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
}
