package com.app.springbootpractice.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    user_id int primary key AUTO_INCREMENT,
//    user_name varchar(100),
//    password varchar(100),
//    gmail varchar(100),
//    phone varchar(100),
//    address varchar(100)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mapp voi cai      AUTO_INCREMENT
    @Column(name = "user_id")
    Integer userId;
    @Column(name = "user_name")
    String userName;
    @Column(name = "password")
    String password;
    @Column(name = "gmail")
    String gmail;
    @Column(name = "phone")
    String phone;
    @Column(name = "address")
    String address;
    @Column(name = "country")
    String country;
}
