package reto4.reto4;

//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reto4.reto4.interfaces.InterfaceOrder;
import reto4.reto4.interfaces.InterfaceProduct;
import reto4.reto4.interfaces.InterfaceUser;

@Component
@SpringBootApplication
public class Reto4Application implements CommandLineRunner {
	@Autowired
	private InterfaceProduct interfaceProduct;
	@Autowired
	private InterfaceUser interfaceUser;
	@Autowired
    private InterfaceOrder interfaceOrder;
	
	public static void main(String[] args) {
		SpringApplication.run(Reto4Application.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		//System.out.println("Pendiente");
		//System.out.println("Usuario :" + UsercrudRepository.findTopByOrderByIdDesc().get());

		//SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		interfaceProduct.deleteAll();
		interfaceUser.deleteAll();
		interfaceOrder.deleteAll();
	}
}//51min //52.09min
