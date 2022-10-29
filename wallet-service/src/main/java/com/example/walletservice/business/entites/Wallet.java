package com.example.walletservice.business.entites;

import lombok.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class Wallet {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

//    @Getter @Setter
    @NonNull Long userId;


    @NonNull
    Float mmdPoints = 0.0f;
}
