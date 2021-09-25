package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Entity
public class Truck {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String truckId;
    private String trailerNumber;
    private String truckLocation;
    private String model;
    private boolean insurance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Objects.equals(id, truck.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
