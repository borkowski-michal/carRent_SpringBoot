package pl.borkowski.carrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.borkowski.carrent.repository.RoleRepo;
import pl.borkowski.carrent.repository.UserRepo;


@EnableJpaRepositories(basePackageClasses = {UserRepo.class,RoleRepo.class})
@SpringBootApplication
public class CarRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentApplication.class, args);
    }

}
