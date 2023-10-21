package WebServices.TP1;

import WebServices.TP1.model.Vehicle;
import WebServices.TP1.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
@Configuration
public class Tp1Application {
	@Autowired
	static VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Tp1Application.class, args);
		VehicleRepository vehicleRepository = context.getBean(VehicleRepository.class);

		// Your repository is now initialized and can be used to perform operations
		List<Vehicle> test = vehicleRepository.findAll();
		System.out.println("THe siza is " + test.size());

		for(Vehicle v : test){
			System.out.println(v.getBrand() + " and year is " + v.getYear());
		}

		System.out.println("---------------------------------------------------");


		// Close the context when you're done
//		context.close();
	}

}
