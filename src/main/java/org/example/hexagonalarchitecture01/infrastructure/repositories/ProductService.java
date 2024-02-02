package org.example.hexagonalarchitecture01.infrastructure.repositories;
import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;
import org.example.hexagonalarchitecture01.infrastructure.entities.ProductEntity;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService implements IProductRepository{

    private final IInfrastructureProductRepository productRepository;

    public ProductService(IInfrastructureProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = ProductEntity.fromDomainModel(product);
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        return savedProductEntity.toDomainModel();
    }

    @Override
    public Optional<Product> findById(String uuid) {
        return productRepository.findByUuid(uuid).map(ProductEntity::toDomainModel);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(ProductEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> update(Product product) {
        if(productRepository.existsByUuid(product.getUuid())){
            ProductEntity productEntity = ProductEntity.fromDomainModel(product);
            ProductEntity updatedProductEntity = productRepository.save(productEntity);
            return Optional.of(updatedProductEntity.toDomainModel());
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Boolean deleteById(String uuid) {
        if (productRepository.existsByUuid(uuid)){
            productRepository.deleteByUuid(uuid);
            return true;
        }

        return false;
    }
}
