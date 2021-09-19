package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    /**
     * Obtener todos los registros
     * @return Lista de ventas
     */
    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    /**
     * Obtener registros por cliente
     * @param clientId
     * @return Lista de ventas
     */
    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    /**
     * Guardar un registro
     * @param purchase
     * @return registro
     */
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

}
