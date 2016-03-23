package pl.mcx.lombok.academy.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Door {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "door")
    private Set<AccessVersion> accessVersions;

    private String number;

    public Door() {
    }

    public Door(final String number) {
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

        final Door door = (Door) o;

        return !(number != null ? !number.equals(door.number) : door.number != null);
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

    public static DoorBuilder builder() {
        return new DoorBuilder();
    }
}
