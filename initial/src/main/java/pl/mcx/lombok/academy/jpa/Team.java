package pl.mcx.lombok.academy.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany
    private Set<Employee> employees;

    public Team() {
    }

    public Team(final String name, final Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Team team = (Team) o;

        return id == team.id && !(name != null ? !name.equals(team.name) : team.name != null);

    }

    @Override
    public int hashCode() {
        final int result = (int) (id ^ (id >>> 32));
        return 31 * result + (name != null ? name.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }

    public static TeamBuilder builder() {
        return new TeamBuilder();
    }
}
