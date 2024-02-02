package org.example.hexagonalarchitecture01.infrastructure.repositories;
import org.example.hexagonalarchitecture01.domain.models.Product;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;
import org.example.hexagonalarchitecture01.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaProductRepositoryAdapter implements IProductRepository{

    private final IJpaProductRepository productRepository;

    public JpaProductRepositoryAdapter(IJpaProductRepository productRepository) {
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
    public Optional<Product> update(String uuid,Product product) {
        if(productRepository.existsByUuid(uuid)){
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
