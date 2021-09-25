package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends Base {

    @Builder
    public Address(Long id, Date modified, Date created, String type, String city, String street,
                   String number, String longitude, String latitude, String time, String date, Load load) {
        super(id, modified, created);
        this.type = type;
        this.city = city;
        this.street = street;
        this.number = number;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
        this.date = date;
        this.load = load;
    }

    private String type;
    private String city;
    private String street;
    private String number;
    private String longitude;
    private String latitude;
    private String time;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Load load;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
