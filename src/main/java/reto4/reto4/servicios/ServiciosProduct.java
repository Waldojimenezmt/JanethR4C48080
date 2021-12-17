package reto4.reto4.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto4.reto4.modelo.ModeloProduct;
import reto4.reto4.repositorio.RepositorioProduct;

@Service
public class ServiciosProduct {
    @Autowired
    private RepositorioProduct ProductRepository;
    
    public List<ModeloProduct> getAll() {
        return ProductRepository.getAll();
    }

    public Optional<ModeloProduct> getReference (String reference) {
        return ProductRepository.getReference(reference);
    }

    public ModeloProduct create(ModeloProduct producto) {
        if (producto.getReference() == null) {
            return producto;
        } else {
            return ProductRepository.create(producto);
        }
    }
    
    public ModeloProduct update(ModeloProduct producto) {

        if (producto.getReference() != null) {
            Optional<ModeloProduct> productDb = ProductRepository.getReference(producto.getReference());
            if (!productDb.isEmpty()) {
                if (producto.getCategory() != null) {
                    productDb.get().setCategory(producto.getCategory());
                }
                if (producto.getDescription() != null) {
                    productDb.get().setDescription(producto.getDescription());
                }
                if (producto.getPrice() != 0.0) {
                    productDb.get().setPrice(producto.getPrice());
                }
                if (producto.getQuantity() != 0) {
                    productDb.get().setQuantity(producto.getQuantity());
                }
                if (producto.getPhotography() != null) {
                    productDb.get().setPhotography(producto.getPhotography());
                }
                productDb.get().setAvailability(producto.isAvailability());
                ProductRepository.update(productDb.get());
                return productDb.get();
            } else {
                return producto;
            }
        } else {
            return producto;
        }
    }

    public boolean delete (String reference) {
        Boolean aBoolean = getReference(reference).map(producto -> {
            ProductRepository.delete(producto);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
