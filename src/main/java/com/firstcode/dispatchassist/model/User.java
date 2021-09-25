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
@Builder
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String driverList;
    private String email;
    private String phoneNumber;
    private String color;
    private String avatar;
    private String startingDate;
    private String birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
