package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
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
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
