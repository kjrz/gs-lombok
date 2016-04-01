package pl.mcx.lombok.academy.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "employees")
@EqualsAndHashCode(exclude = "employees")
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany
    private Set<Employee> employees;

    @Builder(toBuilder = true)
    public Team(final String name, @Singular final Set<Employee> employees) {
        this.name = name;
        this.employees = this.employees == null ? new HashSet<>() : new HashSet<>(employees);
    }
}
