package ua.lviv.iot.performances.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public final class Disco extends Performance {

    Color discoBallColor;

    String musicGenre;

    public Disco(final int id, final String name, final int musiciansNumber, final int avgTicketPrice,
                 final Color discoBallColor, final String musicGenre) {
        super(id, name, musiciansNumber, avgTicketPrice);
        this.discoBallColor = discoBallColor;
        this.musicGenre = musicGenre;
    }
}
