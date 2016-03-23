package pl.mcx.lombok.academy.jpa;

public class DoorBuilder {

    private String number;

    public DoorBuilder number(final String number) {
        this.number = number;
        return this;
    }

    public Door build() {
        return new Door(number);
    }
}