package com.example.demo.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "MEMBER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String birthDay;

    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;
}

