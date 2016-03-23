package pl.mcx.lombok.academy.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findById(Long id);
}
