package org.example.hexagonalarchitecture01.domain.ports.in;

import org.example.hexagonalarchitecture01.domain.models.Product;

public interface ICreateProductUseCase {
    Product createProduct(Product product);
}
