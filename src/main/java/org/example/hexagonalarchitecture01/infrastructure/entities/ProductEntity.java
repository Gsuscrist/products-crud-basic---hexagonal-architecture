package org.example.hexagonalarchitecture01.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.example.hexagonalarchitecture01.domain.models.Product;

@Entity
@Getter @Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String name;
    private String description;
    private Float price;


    public ProductEntity(){}

    public ProductEntity(Long id, String uuid, String name, String description, Float price){
        this.id=id;
        this.uuid=uuid;
        this.name=name;
        this.description=description;
        this.price=price;
    }

    public Product toDomainModel(){
        return new Product(id,uuid,name,description,price);
    }

    public static ProductEntity fromDomainModel(Product product){
        return new ProductEntity(product.getId(), product.getUuid(), product.getName(), product.getDescription(),product.getPrice());
    }
}
