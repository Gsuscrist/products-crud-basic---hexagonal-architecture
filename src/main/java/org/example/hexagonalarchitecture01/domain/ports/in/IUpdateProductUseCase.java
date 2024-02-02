package org.example.hexagonalarchitecture01.domain.ports.in;

import org.example.hexagonalarchitecture01.domain.models.Product;

import java.util.Optional;

public interface IUpdateProductUseCase {

    Optional<Product> updateProduct(String uuid, Product updateProduct);
}
