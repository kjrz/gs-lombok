package pl.mcx.lombok.academy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mcx.lombok.academy.jpa.*;

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner populate(final EmployeeRepository employees, final DoorRepository doors,
                                      final AccessVersionRepository access) {
        return (args) -> {
            final Door door = doors.save(new Door("678A"));
            final Employee tom = employees.save(new EmployeeBuilder().firstName("Tom").lastName("Sand").build());
            access.save(AccessVersion.builder().door(door).employee(tom).build());

            employees.save(Employee.builder().firstName("Paul").lastName("Jackson").build());
            employees.save(Employee.builder().firstName("Martin").lastName("Chekhov").build());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
