package pl.mcx.lombok.academy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mcx.lombok.academy.db.EmployeeBuilder;
import pl.mcx.lombok.academy.db.EmployeeRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            repository.save(new EmployeeBuilder().firstName("Jack").lastName("Bauer").build());
            repository.save(new EmployeeBuilder().firstName("Chloe").lastName("O'Brian").build());
            repository.save(new EmployeeBuilder().firstName("Kim").lastName("Bauer").build());
        };
    }
}
