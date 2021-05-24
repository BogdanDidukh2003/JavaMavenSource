package ua.lviv.iot.performances.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public final class CircusShow extends Performance {

    List<String> animals;

    List<String> acrobatsNames;

    public CircusShow(final int id, final String name, final int musiciansNumber, final int avgTicketPrice,
                      final ArrayList<String> animals, final ArrayList<String> acrobatsNames) {
        super(id, name, musiciansNumber, avgTicketPrice);
        this.animals = animals;
        this.setAcrobatsNames(acrobatsNames);
    }

    public void setAcrobatsNames(List<String> acrobatsNames) {
        acrobatsNames.add("Micheal");
        this.acrobatsNames = acrobatsNames;
    }
}
