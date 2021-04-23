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

    @NonNull String soloistName;

    @NonNull ArrayList<Instrument> instruments;

    public SymphonyOrchestra(final String name, final int musiciansNumber, final int avgTicketPrice,
                             final String soloistName, final ArrayList<Instrument> instruments) {
        super(name, musiciansNumber, avgTicketPrice);
        this.soloistName = soloistName;
        this.instruments = instruments;
    }
}
