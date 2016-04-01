package pl.mcx.lombok.academy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mcx.lombok.academy.jpa.*;

import java.time.ZonedDateTime;

@SpringBootApplication
public class Application {

    @Bean
    public CommandLineRunner populate(final EmployeeRepository employees, final DoorRepository doors,
                                      final AccessVersionRepository access, final TeamRepository teams) {
        return (args) -> {
            final Door door = doors.save(Door.builder().number("678A").build());
            final Employee tom = employees.save(Employee.builder().firstName("Tom").lastName("Sand").build());
            access.save(AccessVersion.builder()
                    .door(door).employee(tom).endValidTime(ZonedDateTime.now().plusYears(1))
                    .build());

            employees.save(Employee.builder().firstName("Paul").lastName("Jackson").build());
            final Employee martin = employees.save(Employee.builder().firstName("Martin").lastName("Chekhov").build());

            final Team teamA = Team.builder().name("A").employee(tom).build();
            teamA.getEmployees().add(martin);
            teams.save(teamA);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
