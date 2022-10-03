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
public class Truck extends Base {

    @Builder
    public Truck(Long id, Date modified, Date created, String truckId, String trailerNumber, String truckLocation,
                 String model, boolean insurance, Driver driver) {
        super(id, modified, created);
        this.truckId = truckId;
        this.trailerNumber = trailerNumber;
        this.truckLocation = truckLocation;
        this.model = model;
        this.insurance = insurance;
        this.driver = driver;
    }

    private String truckId;
    private String trailerNumber;
    private String truckLocation;
    private String model;
    private boolean insurance;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Objects.equals(getId(), truck.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
