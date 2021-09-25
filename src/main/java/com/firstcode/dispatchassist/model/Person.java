package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends Base {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
