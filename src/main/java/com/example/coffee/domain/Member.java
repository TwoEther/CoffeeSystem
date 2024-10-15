package com.example.coffee.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Member {
    @Id
    private String userId;
    private String password;
    private Grade grade;

    public Member() {
    }

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Member(String userId, String password, Grade grade) {
        this.userId = userId;
        this.password = password;
        this.grade = grade;
    }
}
