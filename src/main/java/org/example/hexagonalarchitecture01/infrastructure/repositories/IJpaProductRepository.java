package org.example.hexagonalarchitecture01.infrastructure.repositories;

import org.example.hexagonalarchitecture01.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJpaProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "select * from product_entity where uuid=:uuid",nativeQuery = true)
    Optional<ProductEntity> findByUuid(String uuid);

    @Query(value = "delete from product_entity where uuid=:uuid", nativeQuery = true)
    void deleteByUuid(String uuid);

    @Query(value = "select count(*) > 0 from product_entity where uuid=:uuid", nativeQuery = true)
    boolean existsByUuid(String uuid);
}
