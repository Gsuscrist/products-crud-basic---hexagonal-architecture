package org.example.hexagonalarchitecture01.application.usecases;

import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.in.IUpdateProductUseCase;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;

import java.util.Optional;

public class UpdateProductUseCaseImpl implements IUpdateProductUseCase {
    private  final IProductRepository productRepository;

    public UpdateProductUseCaseImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> updateProduct(String uuid, Product updateProduct) {
        return productRepository.update(uuid,updateProduct);
    }
}
