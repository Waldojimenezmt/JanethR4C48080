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

import reto4.reto4.modelo.ModeloUser;
import reto4.reto4.servicios.ServiciosUser;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class ControladorUser {
    @Autowired
    private ServiciosUser UserService;

    @GetMapping("/all")
    public List<ModeloUser> getAll() {
        return UserService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional <ModeloUser> getUser(@PathVariable("id") int id) {
        return UserService.getUser(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloUser create(@RequestBody ModeloUser user) {
        return UserService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloUser update(@RequestBody ModeloUser user) {
        return UserService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id) {
        return UserService.delete(id);
    }
    
    @GetMapping("/{email}/{password}")
    public ModeloUser authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return UserService.authenticateUser(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return UserService.emailExists(email);
    }
}
