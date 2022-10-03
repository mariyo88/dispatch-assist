package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends Base {

    @Builder(builderMethodName = "childBuilder")
    public Person(Long id, Date modified, Date created, String firstName, String lastName, String phoneNumber, String email) {
        super(id, modified, created);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Size(min = 3, max = 50)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
