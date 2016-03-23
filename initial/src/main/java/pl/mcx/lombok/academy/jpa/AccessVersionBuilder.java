package pl.mcx.lombok.academy.jpa;

import java.time.ZonedDateTime;

public class AccessVersionBuilder {

    private Door door;
    private Employee employee;
    private ZonedDateTime endValidTime;

    public AccessVersionBuilder door(final Door door) {
        this.door = door;
        return this;
    }

    public AccessVersionBuilder employee(final Employee employee) {
        this.employee = employee;
        return this;
    }

    public AccessVersionBuilder endValidTime(final ZonedDateTime endValidTime) {
        this.endValidTime = endValidTime;
        return this;
    }

    public AccessVersion build() {
        return new AccessVersion(door, employee, endValidTime);
    }
}
