package org.example.hexagonalarchitecture01.application.usecases;

import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.in.IGetProductUseCase;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;

import java.util.Optional;

public class GetProductUseCaseImpl implements IGetProductUseCase {
    private  final IProductRepository productRepository;

    public GetProductUseCaseImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProduct(String uuid) {
        return productRepository.findById(uuid);
    }
}

