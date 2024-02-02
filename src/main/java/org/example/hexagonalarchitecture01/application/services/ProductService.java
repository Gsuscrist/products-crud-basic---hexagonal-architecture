package org.example.hexagonalarchitecture01.application.services;

import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class ProductService implements ICreateProductUseCase, IDeleteProductUseCase, IGetProductUseCase, IListProductUseCase, IUpdateProductUseCase {

    private final ICreateProductUseCase createProductUseCase;
    private final IDeleteProductUseCase deleteProductUseCase;
    private final IGetProductUseCase getProductUseCase;
    private final IListProductUseCase listProductUseCase;
    private final IUpdateProductUseCase updateProductUseCase;

    public ProductService(ICreateProductUseCase createProductUseCase, IDeleteProductUseCase deleteProductUseCase, IGetProductUseCase getProductUseCase, IListProductUseCase listProductUseCase, IUpdateProductUseCase updateProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.getProductUseCase = getProductUseCase;
        this.listProductUseCase = listProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }


    @Override
    public Product createProduct(Product product) {
        return createProductUseCase.createProduct(product);
    }

    @Override
    public boolean delete(String uuid) {
        return deleteProductUseCase.delete(uuid);
    }

    @Override
    public Optional<Product> getProduct(String uuid) {
        return getProductUseCase.getProduct(uuid);
    }

    @Override
    public List<Product> listProducts() {
        return listProductUseCase.listProducts();
    }

    @Override
    public Optional<Product> updateProduct(String uuid, Product updateProduct) {
        return updateProductUseCase.updateProduct(uuid,updateProduct);
    }

}
