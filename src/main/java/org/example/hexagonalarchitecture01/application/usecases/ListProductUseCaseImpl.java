package org.example.hexagonalarchitecture01.application.usecases;

import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.in.IListProductUseCase;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;

import java.util.List;

public class ListProductUseCaseImpl implements IListProductUseCase {
    private  final IProductRepository productRepository;

    public ListProductUseCaseImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}
