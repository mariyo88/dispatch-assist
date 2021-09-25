package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Load extends Base {
    private String date;
    private String pickupAddressTimeAndDate;
    private String totalMileage;
    private String currentDistanceFromDelivery;
    private Status driverStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "load")
    @ToString.Exclude
    private List<Address> addresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Load load = (Load) o;
        return Objects.equals(getId(), load.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
