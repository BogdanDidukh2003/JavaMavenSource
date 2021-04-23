package ua.lviv.iot.performances.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;


@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class CircusShow extends Performance {

    ArrayList<String> animals;

    ArrayList<String> acrobatsNames;

    public CircusShow(final String name, final int musiciansNumber, final int avgTicketPrice,
                      final ArrayList<String> animals, final ArrayList<String> acrobatsNames) {
        super(name, musiciansNumber, avgTicketPrice);
        this.animals = animals;
        this.acrobatsNames = acrobatsNames;
    }
}
