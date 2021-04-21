package ua.lviv.iot.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;


@Setter
@Getter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
@NonNull
public final class SymphonyOrchestra extends Performance {

    String soloistName;

    Instrument[] instruments;

    public SymphonyOrchestra(final String name, final int musiciansNumber, final int avgTicketPrice,
                             final String soloistName, final Instrument[] instruments) {
        super(name, musiciansNumber, avgTicketPrice);
        this.soloistName = soloistName;
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "SymphonyOrchestra{" +
                "name='" + this.name + '\''
                + ", musiciansNumber=" + this.musiciansNumber
                + ", avgTicketPrice=" + this.avgTicketPrice
                + ", soloistName='" + this.soloistName + '\''
                + ", instruments=" + Arrays.toString(this.instruments)
                + "}\n";
    }
}
