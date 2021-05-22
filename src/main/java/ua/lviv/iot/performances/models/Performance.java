package ua.lviv.iot.performances.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public class Performance {

    @NonNull int id;

    @NonNull String name;

    @NonNull int musiciansNumber;

    @NonNull int  avgTicketPrice;

    public Performance copy(){
        return new Performance(this.id, this.name, this.musiciansNumber, this.avgTicketPrice);
    }

}
