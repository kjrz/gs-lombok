package pl.mcx.lombok.academy.db;

public class DoorsBuilder {

    private String number;

    public DoorsBuilder number(final String number) {
        this.number = number;
        return this;
    }

    public Doors build() {
        return new Doors(number);
    }
}