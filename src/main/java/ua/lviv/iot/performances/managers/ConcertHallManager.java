package ua.lviv.iot.performances.managers;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import ua.lviv.iot.performances.models.Performance;
import ua.lviv.iot.performances.models.SortOrder;
import java.util.ArrayList;


@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class ConcertHallManager {

    @NonNull ArrayList<Performance> performances;

    public ConcertHallManager(final ArrayList<Performance> performances) {
        this.performances = performances;
    }

    public ArrayList<Performance> searchByMusiciansNumber() {
        ArrayList<Performance> output = new ArrayList<Performance>();
        for (Performance i: this.performances) {
            if (i.getMusiciansNumber() != 0) {
                output.add(i);
            }
        }
        return output;
    }

    public void sortByMusiciansNumber(final SortOrder order) {
        if (order == SortOrder.ASC) {
            this.performances.sort((performance1, performance2) ->
                performance1.getMusiciansNumber() - performance2.getMusiciansNumber()
            );
            return;
        }
        if (order == SortOrder.DESC) {
            this.performances.sort((performance1, performance2) ->
                    performance2.getMusiciansNumber() - performance1.getMusiciansNumber()
            );
            return;
        }
    }

    public void sortByAvgPrice(final SortOrder order) {
        if (order == SortOrder.ASC) {
            this.performances.sort((performance1, performance2) ->
                    performance1.getAvgTicketPrice() - performance2.getAvgTicketPrice()
            );
            return;
        }
        if (order == SortOrder.DESC) {
            this.performances.sort((performance1, performance2) ->
                    performance2.getAvgTicketPrice() - performance1.getAvgTicketPrice()
            );
            return;
        }
    }

    public void printPerformances() {
        System.out.println(this);
    }

}
