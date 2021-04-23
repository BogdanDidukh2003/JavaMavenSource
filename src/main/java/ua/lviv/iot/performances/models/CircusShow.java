package ua.lviv.iot.performances.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;


@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class CircusShow extends Performance {

    ArrayList<String> animals;

    ArrayList<String> acrobatsNames;

    public CircusShow(@NonNull final String name, @NonNull final int musiciansNumber,
                      @NonNull final int avgTicketPrice, @NonNull final ArrayList<String> animals,
                      @NonNull final ArrayList<String> acrobatsNames) {
        super(name, musiciansNumber, avgTicketPrice);
        this.animals = animals;
        this.acrobatsNames = acrobatsNames;
    }
}
