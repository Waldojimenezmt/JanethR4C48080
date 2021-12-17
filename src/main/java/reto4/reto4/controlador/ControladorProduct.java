package reto4.reto4.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto4.reto4.modelo.ModeloProduct;
import reto4.reto4.servicios.ServiciosProduct;

@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin("*")
public class ControladorProduct {
    @Autowired
    private ServiciosProduct ProductService;

    @GetMapping("/all")
    public List<ModeloProduct> getAll() {
        return ProductService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<ModeloProduct> getReference(@PathVariable("reference") String reference) {
        return ProductService.getReference(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloProduct create(@RequestBody ModeloProduct chocolate) {
        return ProductService.create(chocolate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloProduct update(@RequestBody ModeloProduct chocolate) {
        return ProductService.update(chocolate);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return ProductService.delete(reference);
    }

}

