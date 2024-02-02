package org.example.hexagonalarchitecture01.application.usecases;

import org.example.hexagonalarchitecture01.domain.ports.in.IDeleteProductUseCase;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;

public class DeleteProductUseCaseImpl implements IDeleteProductUseCase {
    private  final IProductRepository productRepository;

    public DeleteProductUseCaseImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean delete(String uuid) {
        return productRepository.deleteById(uuid);
    }
}
