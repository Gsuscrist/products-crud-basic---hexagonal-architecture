package org.example.hexagonalarchitecture01.domain.ports.in;

import org.example.hexagonalarchitecture01.domain.models.Product;

import java.util.List;

public interface IListProductUseCase {
    List<Product> listProducts();
}
