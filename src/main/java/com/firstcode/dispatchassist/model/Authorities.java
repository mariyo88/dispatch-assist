package com.firstcode.dispatchassist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(AuthoritiesId.class)
public class Authorities {

    @Id
    private String username;
    @Id
    private String authority;
}
