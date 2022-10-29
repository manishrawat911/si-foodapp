package com.example.productcatalogservice.business.entites;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter @Setter

public class Goodies {

    private @Id @GeneratedValue Long goodiesId;
    private String goodieName;
    private Float mddPoint;

    public Goodies(String goodieName,Float mddPoint)
    {
        this.goodieName = goodieName;
        this.mddPoint = mddPoint;
    }

}
