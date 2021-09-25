package com.firstcode.dispatchassist.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Base {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
