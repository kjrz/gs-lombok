package pl.mcx.lombok.academy.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.Optional;

public interface AccessVersionRepository extends CrudRepository<AccessVersion, Long> {

    @Query("SELECT v FROM AccessVersion v " +
            "JOIN v.door d " +
            "JOIN v.employee e " +
            "WHERE d.id = :doorId " +
            "AND e.id = :employeeId " +
            "AND (v.endValidTime IS NULL " +
            "     OR v.endValidTime >= :checkTime)")
    Optional<AccessVersion> findActiveAccess(@Param("doorId") Long doorId, @Param("employeeId") Long employeeId,
                                             @Param("checkTime") ZonedDateTime checkTime);
}
