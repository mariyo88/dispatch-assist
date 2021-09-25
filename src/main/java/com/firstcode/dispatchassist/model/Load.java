package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Load {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String date;
    private String pickupAddressTimeAndDate;
    private String totalMileage;
    private String currentDistanceFromDelivery;
    private String driverStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Load load = (Load) o;
        return Objects.equals(id, load.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
