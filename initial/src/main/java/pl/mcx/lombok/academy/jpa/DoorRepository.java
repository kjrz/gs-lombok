package pl.mcx.lombok.academy.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoorRepository extends CrudRepository<Door, Long> {

    Optional<Door> findById(Long id);
}
