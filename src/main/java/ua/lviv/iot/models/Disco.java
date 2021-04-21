package ua.lviv.iot.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NonNull
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

    @Override
    public String toString() {
        return "Disco{" +
                "discoBallColor=" + this.discoBallColor
                + ", music_genre='" + this.musicGenre + '\''
                + ", name='" + this.name + '\''
                + ", musiciansNumber=" + this.musiciansNumber
                + ", avgTicketPrice=" + this.avgTicketPrice
                + "}\n";
    }
}
