package pl.mcx.lombok.academy.db;

public class EmployeeBuilder {

    private String firstName;
    private String lastName;

    public EmployeeBuilder firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder lastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee build() {
        return new Employee(firstName, lastName);
    }
}
