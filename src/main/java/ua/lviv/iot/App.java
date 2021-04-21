package ua.lviv.iot;


import lombok.var;
import ua.lviv.iot.managers.ConcertHallManager;
import ua.lviv.iot.models.CircusShow;
import ua.lviv.iot.models.Color;
import ua.lviv.iot.models.Disco;
import ua.lviv.iot.models.Instrument;
import ua.lviv.iot.models.Performance;
import ua.lviv.iot.models.SortOrder;
import ua.lviv.iot.models.SymphonyOrchestra;

import java.util.LinkedList;
import java.util.List;


public final class App {
    private App() {
        throw new AssertionError("Instantiating utility class.");
    }

    public static void main(final String... args) {
        System.out.println("Hello world");
        SymphonyOrchestra opera = new SymphonyOrchestra("opera", 0, 5000,
                "Ban", new Instrument[] {Instrument.TRUMPET, Instrument.CELLO});
        CircusShow horodtska = new CircusShow("circus on Horodotska", 20, 15000,
                new String[]{"dog", "cat"}, new String[] {"Ben", "Dan"});
        Disco malevich = new Disco("Malevich", 30, 25000, Color.RED,
                "techno");
        SymphonyOrchestra balley = new SymphonyOrchestra("opera", 40, 35000,
                "Ban", new Instrument[] {Instrument.TRUMPET, Instrument.CELLO});
        var lvivPerformances = new ConcertHallManager(new LinkedList<Performance>(
                List.of(opera, horodtska, malevich, balley)));
        lvivPerformances.sortByAvgPrice(SortOrder.ASC);
        lvivPerformances.printPerformances();
        lvivPerformances.sortByMusiciansNumber(SortOrder.DESC);
        var funnyPerformances = new ConcertHallManager(lvivPerformances.searchByMusiciansNumber());
        funnyPerformances.sortByMusiciansNumber(ua.lviv.iot.models.SortOrder.DESC);
        funnyPerformances.printPerformances();
    }
}
