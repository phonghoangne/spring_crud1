package com.app.springbootpractice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "university")
public class University {

    // one to many : 1 - n
    // many to one : n - 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;

    //cascadetype // all detech merge , ,refrech,detach
    // persit,remove

    // layzy ( lazy loading )
    // eager ( eager loading )
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    // findById tim thang university -> khi ma lay university  aeger lay 1 unversity -> students cung duoc lay len ;
    // findById tim thang university -> khi may lay university lazy -> student chua duoc lay len -> khi ma truy cap thuoc tinh;


}