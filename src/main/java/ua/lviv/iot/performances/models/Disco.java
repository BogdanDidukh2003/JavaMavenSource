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

    Color discoBallColor;

    String musicGenre;

    public Disco(@NonNull final String name, @NonNull final int musiciansNumber, @NonNull final int avgTicketPrice,
                 @NonNull final Color discoBallColor, @NonNull final String musicGenre) {
        super(name, musiciansNumber, avgTicketPrice);
        this.discoBallColor = discoBallColor;
        this.musicGenre = musicGenre;
    }
}
