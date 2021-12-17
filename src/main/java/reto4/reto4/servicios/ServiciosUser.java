package reto4.reto4.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto4.reto4.modelo.ModeloUser;
import reto4.reto4.repositorio.RepositorioUser;

@Service
public class ServiciosUser {
    @Autowired
    private RepositorioUser UserRepository;
    
    public List<ModeloUser> getAll() {
        return UserRepository.getAll();
    }

    public Optional<ModeloUser> getUser(Integer id) {
        return UserRepository.getUser(id);
    }

    public ModeloUser create(ModeloUser user) {
        /*
        if (user.getId() == null) {
            return user;            
        }else {
             
        }*/
        //Obtiene el maximo id existente en la colección
        Optional <ModeloUser> userIdMaximo = UserRepository.lastUserId();

        //Si el id del Usuario que se recibe como parametro es nulo, entonces se valida el máximo id de la coleccióny le suma 1
        if (user.getId() == null) {
            //Valida el máximo id generado, si no hay  ninguno, el id será 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //Si retorna información suma 1 al máximo id existente y lo asigna al código del id
            else
                user.setId(userIdMaximo.get().getId() + 1); 
        }

        Optional<ModeloUser> e = UserRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false){
                    return UserRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }      
    }

    public ModeloUser update(ModeloUser user) {
        if (user.getId() != null) {
            Optional<ModeloUser> userDb = UserRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                UserRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            UserRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExists(String email) {
        return UserRepository.emailExists(email);
    }

    public ModeloUser authenticateUser(String email, String password) {
        Optional<ModeloUser> usuario = UserRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new ModeloUser();
        } else {
            return usuario.get();
        }
    }
}

