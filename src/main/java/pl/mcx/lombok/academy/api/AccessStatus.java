package pl.mcx.lombok.academy.api;

public enum AccessStatus {
    GRANTED(0),
    DENIED(1);

    private final int value;

    AccessStatus(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
