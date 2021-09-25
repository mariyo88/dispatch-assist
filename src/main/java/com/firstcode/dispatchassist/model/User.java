package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User extends Person {

    @Builder
    public User(Long id, Date modified, Date created, String firstName, String lastName, String phoneNumber,
                String email, String color, String avatar, String startingDate, String birthDate, List<Driver> drivers) {
        super(id, modified, created, firstName, lastName, phoneNumber, email);
        this.color = color;
        this.avatar = avatar;
        this.startingDate = startingDate;
        this.birthDate = birthDate;
        this.drivers = drivers;
    }

    private String color;
    private String avatar;
    private String startingDate;
    private String birthDate;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user")
    @ToString.Exclude
    private List<Driver> drivers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
