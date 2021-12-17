package reto4.reto4.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import reto4.reto4.modelo.ModeloUser;

public interface InterfaceUser extends MongoRepository <ModeloUser, Integer> {
    Optional<ModeloUser> findByEmail(String email);
    Optional<ModeloUser> findByEmailAndPassword(String email,String password);
    //Optional<ModeloUser> findByNameorEmail(String name,String email);

    //Para seleccionar el usuario con el id maximo
    Optional<ModeloUser> findTopByOrderByIdDesc();

    List<ModeloUser> findBybirthtDay(Date date);
    List<ModeloUser> findByMonthBirthtDay(String monthBirthtDay);
    List<ModeloUser> findOneByOrderByIdDesc();
}