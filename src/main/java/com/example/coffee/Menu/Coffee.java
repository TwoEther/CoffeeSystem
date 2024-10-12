package com.example.coffee.Menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;

    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }


    // 회원 기능을 개발할때 관리자만이 수정 가능하도록 해야함
    public void setPrice(int price) {
        this.price = price;
    }
}
