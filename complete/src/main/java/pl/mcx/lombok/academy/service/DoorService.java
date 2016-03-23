package pl.mcx.lombok.academy.service;

public interface DoorService {

    boolean hasAccess(Long doorId, Long employeeId);

    void grantAccess(Long doorId, Long employeeId);

    void denyAccess(Long doorId, Long employeeId);
}
