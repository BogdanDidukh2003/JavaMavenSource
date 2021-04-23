package ua.lviv.iot.performances.models;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString(callSuper = true)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public final class Disco extends Performance {

    Color discoBallColor;

    String musicGenre;

    public Disco(final String name, final int musiciansNumber, final int avgTicketPrice,
                 final Color discoBallColor, final String musicGenre) {
        super(name, musiciansNumber, avgTicketPrice);
        this.discoBallColor = discoBallColor;
        this.musicGenre = musicGenre;
    }
}
