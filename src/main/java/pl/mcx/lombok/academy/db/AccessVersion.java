package pl.mcx.lombok.academy.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccessVersion {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Doors doors;
    private Employee employee;
    private boolean granted;

    public AccessVersion() {
    }

    public AccessVersion(final Doors doors, final Employee employee, final boolean granted) {
        this.doors = doors;
        this.employee = employee;
        this.granted = granted;
    }

    public Doors getDoors() {
        return doors;
    }

    public void setDoors(final Doors doors) {
        this.doors = doors;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    public boolean isGranted() {
        return granted;
    }

    public void setGranted(final boolean granted) {
        this.granted = granted;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final AccessVersion that = (AccessVersion) o;

        return granted == that.granted
                && !(doors != null ? !doors.equals(that.doors) : that.doors != null)
                && !(employee != null ? !employee.equals(that.employee) : that.employee != null);

    }

    @Override
    public int hashCode() {
        return 31 * (31 * (doors != null ? doors.hashCode() : 0) +
                (employee != null ? employee.hashCode() : 0)) +
                (granted ? 1 : 0);
    }

    @Override
    public String toString() {
        return "AccessVersion{" +
                "doors=" + doors +
                ", employee=" + employee +
                ", granted=" + granted +
                '}';
    }
}
