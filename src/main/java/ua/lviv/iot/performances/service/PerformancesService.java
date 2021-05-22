package ua.lviv.iot.performances.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.performances.models.Performance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@ApplicationScope
public class PerformancesService {

    private AtomicInteger id = new AtomicInteger(0);

    private Map<Integer, Performance> performanceMap = new HashMap<>();

    public Performance addPerformance(Performance performance) {
        Integer performanceId = id.incrementAndGet();
        performance.setId(performanceId);
        performanceMap.put(performanceId, performance);
        return performance;
    }

    public Performance updatePerformance(Performance performance) {
        return performanceMap.put(performance.getId(), performance);
    }

    public List<Performance> getPerformance() {
        return performanceMap.values().stream().collect(Collectors.toList());
    }

    public Performance getPerformance(Integer id) {
        return performanceMap.get(id);
    }
}
