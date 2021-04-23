package ua.lviv.iot.performances.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class Disco extends Performance {

    @NonNull Color discoBallColor;

    @NonNull String musicGenre;

    public Disco(final String name, final int musiciansNumber, final int avgTicketPrice,
                 final Color discoBallColor, final String musicGenre) {
        super(name, musiciansNumber, avgTicketPrice);
        this.discoBallColor = discoBallColor;
        this.musicGenre = musicGenre;
    }
}
