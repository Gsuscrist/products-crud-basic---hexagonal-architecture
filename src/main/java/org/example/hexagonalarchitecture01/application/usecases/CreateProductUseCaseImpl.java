package org.example.hexagonalarchitecture01.application.usecases;

import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.in.ICreateProductUseCase;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;

public class CreateProductUseCaseImpl implements ICreateProductUseCase {
    private  final IProductRepository productRepository;

    public CreateProductUseCaseImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
