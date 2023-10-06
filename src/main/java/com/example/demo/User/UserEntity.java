package com.example.demo.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    private Long userId;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String birthDay;
}

