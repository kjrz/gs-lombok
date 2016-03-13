package pl.mcx.lombok.academy.db;

public class AccessVersionBuilder {

    private Doors doors;
    private Employee employee;
    private boolean granted;

    public AccessVersionBuilder doors(final Doors doors) {
        this.doors = doors;
        return this;
    }

    public AccessVersionBuilder employee(final Employee employee) {
        this.employee = employee;
        return this;
    }

    public AccessVersionBuilder granted(final boolean granted) {
        this.granted = granted;
        return this;
    }

    public AccessVersion build() {
        return new AccessVersion(doors, employee, granted);
    }
}
