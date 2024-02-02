package org.example.hexagonalarchitecture01.domain.ports.out;

import org.example.hexagonalarchitecture01.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    Product save(Product product);

    Optional<Product> findById(String uuid);

    List<Product> findAll();

    Optional<Product> update(String uuid,Product product);

    Boolean deleteById(String uuid);
}
