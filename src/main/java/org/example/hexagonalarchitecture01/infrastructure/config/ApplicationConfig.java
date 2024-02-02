package org.example.hexagonalarchitecture01.infrastructure.config;

import org.example.hexagonalarchitecture01.application.services.ProductService;
import org.example.hexagonalarchitecture01.application.usecases.*;
import org.example.hexagonalarchitecture01.domain.ports.out.IProductRepository;
import org.example.hexagonalarchitecture01.infrastructure.repositories.JpaProductRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
    @Bean
    public ProductService productService(IProductRepository repository){
        return new ProductService(
                new CreateProductUseCaseImpl(repository),
                new DeleteProductUseCaseImpl(repository),
                new GetProductUseCaseImpl(repository),
                new ListProductUseCaseImpl(repository),
                new UpdateProductUseCaseImpl(repository)
        );
    }

    @Bean
    public IProductRepository repository(JpaProductRepositoryAdapter repositoryAdapter){
        return repositoryAdapter;
    }






}


//LA APLICACION FALLA CON ESTE ARCHIVO, SE VUELVE UNA INYECCIÓN CICLICA Y E AHI EL PEDO