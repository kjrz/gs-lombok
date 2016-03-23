package pl.mcx.lombok.academy.jpa;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class AccessVersion extends Version {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "door_id")
    private Door door;

    public AccessVersion() {
    }

    public AccessVersion(final Door door, final Employee employee, final ZonedDateTime endValidTime) {
        super(endValidTime);
        this.door = door;
        this.employee = employee;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(final Door door) {
        this.door = door;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final AccessVersion that = (AccessVersion) o;

        return !(door != null ? !door.equals(that.door) : that.door != null) &&
                !(employee != null ? !employee.equals(that.employee) : that.employee != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (door != null ? door.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccessVersion{" +
                "door=" + door +
                ", employee=" + employee +
                ", endValidTime=" + super.getEndValidTime() +
                '}';
    }

    public static AccessVersionBuilder builder() {
        return new AccessVersionBuilder();
    }
}
