package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Obtener todos los registros
     * @return Lista de registros
     */
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    /**
     * Obtener un registro
     * @param productId
     * @return registro
     */
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    /**
     * Obtener registros por categoria
     * @param categoryId
     * @return Lista de registros
     */
    public Optional<List<Product>> getByCategory (int categoryId){
        return productRepository.getByCategoryId(categoryId);
    }

    /**
     * Guardar un registro
     * @param product
     * @return registro
     */
    public Product save(Product product){
        return productRepository.save(product);
    }

    /**
     * Eliminar un registro
     * @param productId
     * @return boolean
     */
    public boolean delete(int productId){
        // si existe el producto, se elimina
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
