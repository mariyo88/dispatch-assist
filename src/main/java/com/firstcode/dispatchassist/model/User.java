package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User extends Person {

    @Builder
    public User(Long id, Date modified, Date created, String firstName, String lastName, String phoneNumber,
                String email, String color, Byte[] avatar, String startingDate, String birthDate, List<Driver> drivers) {
        super(id, modified, created, firstName, lastName, phoneNumber, email);
        this.color = color;
        this.avatar = avatar;
        this.startingDate = startingDate;
        this.birthDate = birthDate;
        this.drivers = drivers;
    }

    @Size(min = 4, message = "Your username length must be grater then 4.")
    private String username;

    private String password;
    private boolean enabled;
    private String address;
    private String address2;
    private String color;

    @Lob
    private Byte[] avatar;
    private String startingDate;
    private String birthDate;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user")
    private List<Driver> drivers;

    @Override
    public String toString() {
        return "User{" +
                "color='" + color + '\'' +
                ", avatar='" + avatar + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", birthDate='" + birthDate + '\'' +
                "} " + super.toString();
    }

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
