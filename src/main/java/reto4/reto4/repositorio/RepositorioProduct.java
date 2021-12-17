package reto4.reto4.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto4.reto4.interfaces.InterfaceProduct;
import reto4.reto4.modelo.ModeloProduct;

@Repository
public class RepositorioProduct {
    @Autowired
    private InterfaceProduct ProductCRUDRepository;

    public List<ModeloProduct> getAll() {
        return ProductCRUDRepository.findAll();
    }

    public Optional<ModeloProduct> getReference(Integer id) {
        return ProductCRUDRepository.findById(id);
    }

    public Optional<ModeloProduct> getReference(String reference) {
        return ProductCRUDRepository.findByReference(reference);
    }

    public ModeloProduct create(ModeloProduct reference) {
        return ProductCRUDRepository.save(reference);
    }

    public void update(ModeloProduct reference) {
        ProductCRUDRepository.save(reference);
    }
    
    public void delete(ModeloProduct reference) {
        ProductCRUDRepository.delete(reference);
    }
}

