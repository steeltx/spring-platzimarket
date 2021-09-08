package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    /**
     * Obtener todos los registros
     * @return lista de registros
     */
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    /**
     * Obtener registro por categoria
     * @param idCategoria
     * @return lista de registros
     */
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    /**
     * Obtener los registros escasos
     * @param cantidad
     * @return lista de registros
     */
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado( cantidad, true);
    }

    /**
     * Obtener registro por id
     * @param id
     * @return registro
     */
    public Optional<Producto> getProducto(int id){
        return productoCrudRepository.findById(id);
    }

    /**
     * Ingresar un registro
     * @param producto
     * @return registro
     */
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    /**
     * Eliminar un registro
     * @param idProducto
     */
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

}
