package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends Person {

    @Builder
    public Driver(Long id, Date modified, Date created, String firstName, String lastName, String phoneNumber,
                  String email, String link, String conformations, String residence, String schedule, List<Load> loads, User user) {
        super(id, modified, created, firstName, lastName, phoneNumber, email);
        this.link = link;
        this.conformations = conformations;
        this.residence = residence;
        this.schedule = schedule;
        this.loads = loads;
        this.user = user;
    }

    private String link;
    private String conformations;
    private String residence;
    private String schedule;
    private DriverStatus status;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "driver")
    @ToString.Exclude
    private List<Load> loads;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Truck truck;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(this.getId(), driver.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
