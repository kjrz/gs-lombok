package pl.mcx.lombok.academy.jpa;

import java.util.HashSet;
import java.util.Set;

public class TeamBuilder {

    private String name;
    private Set<Employee> employees = new HashSet<>();

    public TeamBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public TeamBuilder employees(final Set<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public TeamBuilder employee(final Employee employee) {
        this.employees.add(employee);
        return this;
    }

    public Team build() {
        return new Team(name, employees);
    }
}
