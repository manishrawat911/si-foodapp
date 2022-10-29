package com.example.userservice.business.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    private @Id
    @GeneratedValue Long userId;
    private String userName;
    public User(String userName){
        this.userName = userName;
    }
}
