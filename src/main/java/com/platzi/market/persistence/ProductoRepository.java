package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    /**
     * Obtener todos los registros
     * @return lista de registros
     */
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    /**
     * Obtener un registro por categoria
     * @param category
     * @return lista de registros
     */
    @Override
    public Optional<List<Product>> getByCategoryId(int category) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(category);
        return Optional.of(mapper.toProducts(productos));
    }

    /**
     * Obtener registros escasos
     * @param quantity
     * @return lista de registros
     */
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado( quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    /**
     * Obtener registro por id
     * @param productId
     * @return registro
     */
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    /**
     * Guardar un registro
     * @param product
     * @return registro
     */
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /**
     * Eliminar un registro
     * @param idProducto
     */
    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
