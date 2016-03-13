package pl.mcx.lombok.academy.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private Set<AccessVersion> accessVersions;

    protected Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Set<AccessVersion> getAccessVersions() {
        return accessVersions;
    }

    public void setAccessVersions(final Set<AccessVersion> accessVersions) {
        this.accessVersions = accessVersions;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Employee employee = (Employee) o;

        return !(firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) &&
                !(lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null);

    }

    @Override
    public int hashCode() {
        return 31 * (firstName != null ? firstName.hashCode() : 0) + (lastName != null ? lastName.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
