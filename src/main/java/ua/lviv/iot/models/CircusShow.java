package ua.lviv.iot.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;


@Setter
@Getter
@NonNull
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class CircusShow extends Performance {

    String[] animals;

    String[] acrobatsNames;

    public CircusShow(final String name, final int musiciansNumber, final int avgTicketPrice,
                      final String[] animals, final String[] acrobatsNames) {
        super(name, musiciansNumber, avgTicketPrice);
        this.animals = animals;
        this.acrobatsNames = acrobatsNames;
    }

    @Override
    public String toString() {
        return "CircusShow{"
                + "animals=" + Arrays.toString(this.animals)
                + ", acrobatsNames=" + Arrays.toString(this.acrobatsNames)
                + ", name='" + this.name + '\''
                + ", musiciansNumber=" + this.musiciansNumber
                + ", avgTicketPrice=" + this.avgTicketPrice
                + "}\n";
    }
}
