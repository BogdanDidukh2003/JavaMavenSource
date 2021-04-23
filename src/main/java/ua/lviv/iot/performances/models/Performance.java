package ua.lviv.iot.performances.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public abstract class Performance {

    @NonNull String name;

    @NonNull int musiciansNumber;

    @NonNull int  avgTicketPrice;

}
