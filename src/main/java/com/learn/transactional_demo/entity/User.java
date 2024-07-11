package com.learn.transactional_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// db takes care of the id.
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer age;

}
