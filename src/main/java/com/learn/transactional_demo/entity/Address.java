package com.learn.transactional_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// db takes care of the id.
    private int id;

    @Column
    private String no;

    @Column
    private String lane;

    @Column
    private String city;

    @Column
    private String province;

}
