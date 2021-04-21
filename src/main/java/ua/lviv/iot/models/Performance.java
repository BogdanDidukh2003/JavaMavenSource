package ua.lviv.iot.models;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NonNull
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PROTECTED)
public abstract class Performance {

    String name;

    int musiciansNumber;

    int  avgTicketPrice;

}
