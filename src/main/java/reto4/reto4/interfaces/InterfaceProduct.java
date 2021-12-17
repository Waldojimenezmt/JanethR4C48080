package reto4.reto4.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import reto4.reto4.modelo.ModeloProduct;

public interface InterfaceProduct extends MongoRepository <ModeloProduct, Integer> {
    Optional<ModeloProduct> findByReference(String reference);
    Optional<ModeloProduct> findByReferenceAndDescription(String reference, String description);
}
