package de.telran.appforpeople.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "people")
public class Person {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;


}
