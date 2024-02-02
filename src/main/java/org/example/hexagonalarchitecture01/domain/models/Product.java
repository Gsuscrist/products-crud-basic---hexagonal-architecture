package org.example.hexagonalarchitecture01.domain.models;

import lombok.*;

@Getter  @Setter
public class Product {
    private Long id;
    private String uuid;
    private String name;
    private String description;
    private Float price;

    public Product(Long id, String uuid, String name, String description, Float price){
        this.id=id;
        this.uuid=uuid;
        this.name=name;
        this.description=description;
        this.price=price;
    }


}
