package pl.mcx.lombok.academy.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Doors {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String number;
    private Set<AccessVersion> accessVersions;

    public Doors() {
    }

    public Doors(final String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
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

        final Doors doors = (Doors) o;

        return !(number != null ? !number.equals(doors.number) : doors.number != null);
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Doors{" +
                "number='" + number + '\'' +
                '}';
    }
}
