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
public class Load extends Base {

    @Builder
    public Load(Long id, Date modified, Date created, String date, Double mileage, Double distance,
                LoadStatus status, List<Address> addresses, Driver driver, String client) {
        super(id, modified, created);
        this.date = date;
        this.mileage = mileage;
        this.distance = distance;
        this.status = status;
        this.addresses = addresses;
        this.driver = driver;
        this.client = client;
    }

    private String date;
    private Double mileage;
    private Double distance;
    private LoadStatus status;
    private String client;

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
