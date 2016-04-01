package pl.mcx.lombok.academy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mcx.lombok.academy.jpa.*;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@Slf4j
public final class DoorServiceImpl implements DoorService {

    private final DoorRepository doorRepository;
    private final EmployeeRepository employeeRepository;
    private final AccessVersionRepository accessVersionRepository;

    @Autowired
    public DoorServiceImpl(final DoorRepository doorRepository, final EmployeeRepository employeeRepository,
                           final AccessVersionRepository accessVersionRepository) {
        this.doorRepository = doorRepository;
        this.employeeRepository = employeeRepository;
        this.accessVersionRepository = accessVersionRepository;
    }

    @Override
    public boolean hasAccess(final Long doorId, final Long employeeId) {
        checkExist(doorId, employeeId);

        return getActiveAccess(doorId, employeeId).isPresent();
    }

    @Override
    public void grantAccess(final Long doorId, final Long employeeId) {
        final Door door = getDoor(doorId);
        final Employee employee = getEmployee(employeeId);

        if (getActiveAccess(doorId, employeeId).isPresent()) {
            return;
        }

        accessVersionRepository.save(AccessVersion.builder()
                .door(door).employee(employee)
                .build());
    }

    @Override
    public void denyAccess(final Long doorId, final Long employeeId) {
        checkExist(doorId, employeeId);

        getActiveAccess(doorId, employeeId).ifPresent(this::deactivateVersion);
    }

    private void checkExist(final Long doorId, final Long employeeId) {
        getDoor(doorId);         // throws NoSuchDoorException
        getEmployee(employeeId); // throws NoSuchEmployeeException
    }

    private Optional<AccessVersion> getActiveAccess(final Long doorId, final Long employeeId) {
        Optional<AccessVersion> activeAccess = accessVersionRepository.findActiveAccess(doorId, employeeId,
                ZonedDateTime.now());
        activeAccess.map(Object::toString).ifPresent(LOG::info);
        return activeAccess;
    }

    private Door getDoor(final Long doorId) {
        return doorRepository.findById(doorId)
                .orElseThrow(() -> new NoSuchDoorException("No door with id=" + doorId));
    }

    private Employee getEmployee(final Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchEmployeeException("No employee with id=" + employeeId));
    }

    private void deactivateVersion(final AccessVersion access) {
        access.setEndValidTime(ZonedDateTime.now());
        accessVersionRepository.save(access);
    }
}
