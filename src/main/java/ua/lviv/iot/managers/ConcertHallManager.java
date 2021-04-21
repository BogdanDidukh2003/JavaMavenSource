package ua.lviv.iot.managers;


import lombok.Data;
import lombok.NonNull;
import ua.lviv.iot.models.Performance;
import ua.lviv.iot.models.SortOrder;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

@Data
@NonNull
public final class ConcertHallManager {

    private LinkedList<Performance> performances;

    public ConcertHallManager(final LinkedList<Performance> performances) {
        this.performances = performances;
    }

    public LinkedList<Performance> searchByMusiciansNumber() {
        LinkedList<Performance> output = new LinkedList<Performance>();
        for (Performance i: this.performances) {
            if (i.getMusiciansNumber() != 0) {
                output.add(i);
            }
        }
        return output;
    }

    public void sortByMusiciansNumber(final SortOrder order) {
        Collections.sort(this.performances, new Comparator<Performance>() {
            @Override
            public int compare(final Performance o1, final Performance o2) {
                return o1.getMusiciansNumber() - o2.getMusiciansNumber();
            }
        });
        if (order == SortOrder.DESC) {
            Collections.reverse(this.performances);
        }
    }

    public void sortByAvgPrice(final SortOrder order) {
        Collections.sort(this.performances, new Comparator<Performance>() {
            @Override
            public int compare(final Performance o1, final Performance o2) {
                return o1.getAvgTicketPrice() - o2.getAvgTicketPrice();
            }
        });
        if (order == SortOrder.DESC) {
            Collections.reverse(this.performances);
        }
    }

    public void printPerformances() {
        System.out.println(this);
    }

}
