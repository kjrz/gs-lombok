package pl.mcx.lombok.academy.api;

public enum AccessStatusCode {
    GRANTED(0),
    DENIED(1);

    private final int value;

    AccessStatusCode(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
