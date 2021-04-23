package ua.lviv.iot.performances;


import lombok.var;
import ua.lviv.iot.performances.managers.ConcertHallManager;
import ua.lviv.iot.performances.models.CircusShow;
import ua.lviv.iot.performances.models.Color;
import ua.lviv.iot.performances.models.Disco;
import ua.lviv.iot.performances.models.Instrument;
import ua.lviv.iot.performances.models.Performance;
import ua.lviv.iot.performances.models.SortOrder;
import ua.lviv.iot.performances.models.SymphonyOrchestra;

import java.util.ArrayList;
import java.util.List;


public final class App {
    private App() {
        throw new AssertionError("Instantiating utility class.");
    }

    public static void main(final String... args) {
        SymphonyOrchestra lvivNationalPhilharmonic = new SymphonyOrchestra("lvivNationalPhilharmonic",
                0, 5000,
                "Ban", new ArrayList<Instrument>(List.of(Instrument.TRUMPET, Instrument.CELLO)));

        CircusShow lvivCircus = new CircusShow("lvivCircus", 20, 15000,
                new ArrayList<String>(List.of("dog", "cat")), new ArrayList<String>(List.of("Ben", "Dan")));

        Disco lvivMalevichNightClub = new Disco("lvivMalevichNightClub", 30, 25000, Color.RED,
                "techno");

        SymphonyOrchestra lvivOperaTheater = new SymphonyOrchestra("lvivOperaTheater", 40, 35000,
                "Ban", new ArrayList<Instrument>(List.of(Instrument.TRUMPET, Instrument.CELLO)));

        var lvivPerformances = new ConcertHallManager(new ArrayList<Performance>(
                List.of(lvivNationalPhilharmonic, lvivCircus, lvivOperaTheater, lvivMalevichNightClub)));

        lvivPerformances.sortByAvgPrice(SortOrder.ASC);
        lvivPerformances.printPerformances();
        lvivPerformances.sortByMusiciansNumber(SortOrder.DESC);
        var funnyPerformances = new ConcertHallManager(lvivPerformances.searchByMusiciansNumber());
        funnyPerformances.sortByMusiciansNumber(ua.lviv.iot.performances.models.SortOrder.DESC);
        funnyPerformances.printPerformances();
    }
}
