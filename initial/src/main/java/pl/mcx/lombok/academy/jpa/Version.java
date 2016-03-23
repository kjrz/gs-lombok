package pl.mcx.lombok.academy.jpa;

import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class Version {

    private ZonedDateTime endValidTime;

    public Version() {
    }

    public Version(final ZonedDateTime endValidTime) {
        this.endValidTime = endValidTime;
    }

    public ZonedDateTime getEndValidTime() {
        return endValidTime;
    }

    public void setEndValidTime(final ZonedDateTime endValidTime) {
        this.endValidTime = endValidTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Version version = (Version) o;

        return endValidTime.equals(version.endValidTime);

    }

    @Override
    public int hashCode() {
        return endValidTime.hashCode();
    }
}
