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
public final class SymphonyOrchestra extends Performance {

    String soloistName;

    ArrayList<Instrument> instruments;

    public SymphonyOrchestra(@NonNull final String name, @NonNull final int musiciansNumber,
                             @NonNull final int avgTicketPrice, @NonNull final String soloistName,
                             @NonNull final ArrayList<Instrument> instruments) {
        super(name, musiciansNumber, avgTicketPrice);
        this.soloistName = soloistName;
        this.instruments = instruments;
    }
}
