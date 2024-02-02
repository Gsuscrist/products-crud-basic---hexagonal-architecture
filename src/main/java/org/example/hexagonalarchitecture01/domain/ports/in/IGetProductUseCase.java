package org.example.hexagonalarchitecture01.domain.ports.in;

import org.example.hexagonalarchitecture01.domain.models.Product;

import java.util.Optional;

public interface IGetProductUseCase {
    Optional<Product> getProduct(String uuid);
}
