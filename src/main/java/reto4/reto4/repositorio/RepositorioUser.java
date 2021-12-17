package reto4.reto4.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto4.reto4.interfaces.InterfaceUser;
import reto4.reto4.modelo.ModeloUser;

@Repository
public class RepositorioUser {
    @Autowired
    private InterfaceUser UserCRUDRepository;

    public List<ModeloUser> getAll() {
        return (List<ModeloUser>) UserCRUDRepository.findAll();
    }

    public Optional<ModeloUser> getUser (int id) {
        return UserCRUDRepository.findById(id);
    }

    public ModeloUser create(ModeloUser user) {
        return UserCRUDRepository.save(user);
    }
        
    public void update(ModeloUser user) {
        UserCRUDRepository.save(user);
    }
        
    public void delete(ModeloUser user) {
        UserCRUDRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<ModeloUser> usuario = UserCRUDRepository.findByEmail(email); 
        return !usuario.isEmpty();
    }
        
    public Optional<ModeloUser> authenticateUser(String email, String password) {
        return UserCRUDRepository.findByEmailAndPassword(email, password);
    }

    public Optional<ModeloUser> lastUserId(){
        return UserCRUDRepository.findTopByOrderByIdDesc();
    }
}
