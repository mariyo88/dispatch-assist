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
public class Driver {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String profileLink;
    private String loadConformations;
    private String dedicatedDispatcher;
    private String placeOfResidence;
    private String schedule;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "driver")
    private List<Load> loads;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
