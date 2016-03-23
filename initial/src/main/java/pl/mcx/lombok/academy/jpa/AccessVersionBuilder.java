package pl.mcx.lombok.academy.jpa;

public class AccessVersionBuilder {

    private Door door;
    private Employee employee;

    public AccessVersionBuilder door(final Door door) {
        this.door = door;
        return this;
    }

    public AccessVersionBuilder employee(final Employee employee) {
        this.employee = employee;
        return this;
    }

    public AccessVersion build() {
        return new AccessVersion(door, employee);
    }
}
